package optimizers.local;

import optimizers.utils.BasicBloc;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.ArithmeticInstruction;
import tac.instructions.array.NewArrayInstruction;
import tac.instructions.binary.BinaryInstruction;
import tac.instructions.io.ReadInstruction;
import tac.instructions.length.LengthInstruction;
import tac.instructions.subprogram.calls.FunctionCallInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

import java.util.*;
import java.util.stream.Collectors;

public final class UnusedDefinitionsOptimizer extends LocalOptimizer {
    public UnusedDefinitionsOptimizer(List<TACInstruction> unoptimizedInstructions, Collection<BasicBloc> basicBlocs) {
        super(unoptimizedInstructions, basicBlocs);
    }

    @Override
    public List<TACInstruction> optimize() {
        Set<TACVariable> usedVariables = new HashSet<>();
        unoptimizedInstructions.forEach(instruction -> usedVariables.addAll(arguments(instruction)));
        return unoptimizedInstructions.stream()
                .filter(instruction -> !optimizable(usedVariables, instruction))
                .collect(Collectors.toList());
    }

    private Collection<TACVariable> arguments(TACInstruction instruction) {
        List<TACVariable> arguments = new ArrayList<>();
        if (!isDefinition(instruction)) {
            addIfVariable(arguments, instruction.getFirstReference());
        }
        addIfVariable(arguments, instruction.getSecondReference());
        addIfVariable(arguments, instruction.getThirdReference());
        return arguments;
    }

    private boolean optimizable(Set<TACVariable> usedVariables, TACInstruction instruction) {
        return isDefinition(instruction) && !usedVariables.contains(instruction.getFirstReference());
    }

    private boolean isDefinition(TACInstruction instruction) {
        return instruction instanceof ArithmeticInstruction || instruction instanceof BinaryInstruction ||
                instruction instanceof NewArrayInstruction || instruction instanceof ReadInstruction ||
                instruction instanceof LengthInstruction || instruction instanceof FunctionCallInstruction;
    }

    private void addIfVariable(List<TACVariable> list, TACReference reference) {
        if (reference instanceof TACVariable) {
            list.add((TACVariable) reference);
        }
    }
}
