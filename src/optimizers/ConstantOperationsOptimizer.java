package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.*;
import tac.instructions.binary.AndInstruction;
import tac.instructions.binary.BinaryInstruction;
import tac.instructions.binary.NotInstruction;
import tac.instructions.binary.OrInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.ArrayList;
import java.util.List;

public final class ConstantOperationsOptimizer extends TACOptimizer {
    public ConstantOperationsOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            optimizedInstructions.add(canBeOptimized(instruction) ? optimize(instruction) : instruction);
        }
        return optimizedInstructions;
    }

    private boolean canBeOptimized(TACInstruction instruction) {
        return twoArgumentsInstructionCanBeOptimized(instruction) || threeArgumentsInstructionCanBeOptimized(instruction);
    }

    private boolean twoArgumentsInstructionCanBeOptimized(TACInstruction instruction) {
        return (instruction instanceof NegativeInstruction || instruction instanceof NotInstruction) &&
                instruction.getSecondReference() instanceof TACLiteral;
    }

    private boolean threeArgumentsInstructionCanBeOptimized(TACInstruction instruction) {
        return (instruction instanceof ArithmeticInstruction || instruction instanceof BinaryInstruction) &&
                instruction.getSecondReference() instanceof TACLiteral &&
                instruction.getThirdReference() instanceof TACLiteral;
    }

    private TACInstruction optimize(TACInstruction instruction) {
        return isTwoArgumentsInstruction(instruction) ?
                optimizeTwoArgumentsInstruction(instruction) :
                optimizeThreeArgumentsInstruction(instruction);
    }

    private boolean isTwoArgumentsInstruction(TACInstruction instruction) {
        return instruction.getThirdReference() == null;
    }

    private TACInstruction optimizeTwoArgumentsInstruction(TACInstruction instruction) {
        TACVariable firstVariable = (TACVariable) instruction.getFirstReference();
        Object value = ((TACLiteral) instruction.getSecondReference()).getValue(),
                newValue = instruction instanceof NegativeInstruction ? -(Integer) value : !(Boolean) value;
        return new CopyInstruction(firstVariable, new TACLiteral(newValue));
    }

    private TACInstruction optimizeThreeArgumentsInstruction(TACInstruction instruction) {
        TACVariable firstVariable = (TACVariable) instruction.getFirstReference();
        return new CopyInstruction(firstVariable, getNewValue(instruction));
    }

    private TACLiteral getNewValue(TACInstruction instruction) {
        Object secondLiteral = (((TACLiteral) instruction.getSecondReference()).getValue()),
                thirdLiteral = (((TACLiteral) instruction.getThirdReference()).getValue());
        Object newValue;
        if (instruction instanceof AddInstruction) {
            newValue = (Integer) secondLiteral + (Integer) thirdLiteral;
        } else if (instruction instanceof DivideInstruction) {
            newValue = (Integer) secondLiteral / (Integer) thirdLiteral;
        } else if (instruction instanceof ModuloInstruction) {
            newValue = (Integer) secondLiteral % (Integer) thirdLiteral;
        } else if (instruction instanceof ProductInstruction) {
            newValue = (Integer) secondLiteral * (Integer) thirdLiteral;
        } else if (instruction instanceof SubtractInstruction) {
            newValue = (Integer) secondLiteral - (Integer) thirdLiteral;
        } else if (instruction instanceof AndInstruction) {
            newValue = (Boolean) secondLiteral && (Boolean) thirdLiteral;
        } else if (instruction instanceof OrInstruction) {
            newValue = (Boolean) secondLiteral || (Boolean) thirdLiteral;
        } else {
            throw new RuntimeException(instruction + " not recognized by ConstantOperationsOptimizer");
        }
        return new TACLiteral(newValue);
    }
}
