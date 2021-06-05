package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.DivideInstruction;
import tac.instructions.arithmetic.ModuloInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.references.TACLiteral;
import tac.references.TACReference;
import tac.references.TACVariable;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticOperationsOptimizer extends TACOptimizer {
    public ArithmeticOperationsOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (!canBeRemoved(instruction)) {
                optimizedInstructions.add(canBeOptimized(instruction) ? optimize(instruction) : instruction);
            }
        }
        return optimizedInstructions;
    }

    private boolean canBeOptimized(TACInstruction instruction) {
        return optimizableInstructionType(instruction) && containsOneAsOperator(instruction);
    }

    private boolean canBeRemoved(TACInstruction instruction) {
        return canBeOptimized(instruction) &&
                instruction.getFirstReference().equals(instruction.getSecondReference()) &&
                !(instruction instanceof ModuloInstruction);
    }

    private boolean optimizableInstructionType(TACInstruction instruction) {
        return instruction instanceof ProductInstruction ||
                instruction instanceof DivideInstruction ||
                instruction instanceof ModuloInstruction;
    }

    private boolean containsOneAsOperator(TACInstruction instruction) {
        return valueIsOne(instruction.getSecondReference()) || valueIsOne(instruction.getThirdReference());
    }

    private boolean valueIsOne(TACReference reference) {
        return reference instanceof TACLiteral && ((Integer) ((TACLiteral) reference).getValue()) == 1;
    }

    private TACInstruction optimize(TACInstruction instruction) {
        return new CopyInstruction((TACVariable) instruction.getFirstReference(), getNewValue(instruction));
    }

    private TACReference getNewValue(TACInstruction instruction) {
        if (instruction instanceof ProductInstruction || instruction instanceof DivideInstruction) {
            return getDifferentToOneReference(instruction.getSecondReference(), instruction.getThirdReference());
        } else { // ModuloInstruction
            return new TACLiteral(0);
        }
    }

    private TACReference getDifferentToOneReference(TACReference reference1, TACReference reference2) {
        return valueIsOne(reference1) ? reference2 : reference1;
    }
}
