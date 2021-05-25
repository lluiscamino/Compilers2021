package optimizers;

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
public final class DifferedAssignmentsOptimizer extends TACOptimizer {
    public DifferedAssignmentsOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        Set<TACVariable> uses = new HashSet<>();
        Set<TACVariable> assignments = new HashSet<>();
        Map<TACVariable, TACReference> equivalentVariables = new HashMap<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (instruction instanceof CopyInstruction && ((TACVariable) instruction.getFirstReference()).isTemporal()) {
                addOrRemove(assignments, instruction.getFirstReference());
                equivalentVariables.put((TACVariable) instruction.getFirstReference(), instruction.getSecondReference());
            } else {
                addOrRemove(uses, instruction.getFirstReference());
            }
            addOrRemove(uses, instruction.getSecondReference());
            addOrRemove(uses, instruction.getThirdReference());
        }
        uses.retainAll(assignments); // Intersection
        return generateOptimizedCode(uses, equivalentVariables);
    }

    private void addOrRemove(Set<TACVariable> set, TACReference reference) {
        if (reference instanceof TACVariable && !set.remove(reference)) {
            set.add((TACVariable) reference);
        }
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
