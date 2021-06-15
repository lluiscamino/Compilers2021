package optimizers.peephole;

import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

import java.util.*;

/**
 * Searches and optimizes differed assignments.
 * A differed assignment is an assignment of a temporal variable that is only used once.
 * For example, the following sequence of instructions:
 * <pre>
 *     t = ...
 *     x = t
 * </pre>
 * Would be converted into this:
 * <pre>
 *     x = ...
 * </pre>
 */
public final class DifferedAssignmentsOptimizer extends PeepholeOptimizer {
    public DifferedAssignmentsOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        Map<TACVariable, Integer> uses = new HashMap<>();
        Map<TACVariable, Integer> assignments = new HashMap<>();
        Map<TACVariable, TACReference> equivalentVariables = new HashMap<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (instruction instanceof CopyInstruction && ((TACVariable) instruction.getFirstReference()).isTemporal()) {
                addToMap(assignments, instruction.getFirstReference());
                equivalentVariables.put((TACVariable) instruction.getFirstReference(), instruction.getSecondReference());
            } else {
                addToMap(uses, instruction.getFirstReference());
            }
            addToMap(uses, instruction.getSecondReference());
            addToMap(uses, instruction.getThirdReference());
        }
        Set<TACVariable> onlyOneUse = onlyUsedOnceVariables(uses);
        Set<TACVariable> onlyOneAssignment = onlyUsedOnceVariables(assignments);
        onlyOneUse.retainAll(onlyOneAssignment); // Intersection
        return generateOptimizedCode(onlyOneUse, equivalentVariables);
    }

    private void addToMap(Map<TACVariable, Integer> map, TACReference reference) {
        if (reference instanceof TACVariable) {
            TACVariable variable = (TACVariable) reference;
            map.put(variable, map.getOrDefault(variable, 0) + 1);
        }
    }

    private Set<TACVariable> onlyUsedOnceVariables(Map<TACVariable, Integer> variables) {
        Set<TACVariable> onlyUsedOnceVariables = new HashSet<>();
        for (TACVariable variable : variables.keySet()) {
            if (variables.get(variable) == 1) {
                onlyUsedOnceVariables.add(variable);
            }
        }
        return onlyUsedOnceVariables;
    }

    private List<TACInstruction> generateOptimizedCode(Set<TACVariable> replaceableVariables, Map<TACVariable, TACReference> equivalentVariables) {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (!omissibleAssignment(instruction, replaceableVariables)) {
                optimizedInstructions.add(instruction);
                replaceInstructionReferences(instruction, replaceableVariables, equivalentVariables);
            }
        }
        return optimizedInstructions;
    }

    private boolean omissibleAssignment(TACInstruction instruction, Set<TACVariable> replaceableVariables) {
        return instruction instanceof CopyInstruction && replaceableVariables.contains(instruction.getFirstReference());
    }

    private void replaceInstructionReferences(TACInstruction instruction, Set<TACVariable> replaceableVariables, Map<TACVariable, TACReference> equivalentVariables) {
        if (replaceableVariables.contains(instruction.getFirstReference())) {
            instruction.setFirstReference(equivalentVariables.get(instruction.getFirstReference()));
        }
        if (replaceableVariables.contains(instruction.getSecondReference())) {
            instruction.setSecondReference(equivalentVariables.get(instruction.getSecondReference()));
        }
        if (replaceableVariables.contains(instruction.getThirdReference())) {
            instruction.setThirdReference(equivalentVariables.get(instruction.getThirdReference()));
        }
    }
}
