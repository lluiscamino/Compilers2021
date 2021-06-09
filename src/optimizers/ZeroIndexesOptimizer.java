package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACReference;
import tac.references.TACVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Optimizes IndexAssignmentInstructions with secondReference set to 0
 * and IndexedValueInstructions with thirdReference set to 0.
 */
public final class ZeroIndexesOptimizer extends TACOptimizer {
    public ZeroIndexesOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (isOptimizableIndexAssignmentInstruction(instruction)) {
                optimizedInstructions.add(optimizeIndexAssignmentInstruction(instruction));
            } else if (isOptimizableIndexedValueInstruction(instruction)) {
                optimizedInstructions.add(optimizeIndexedValueInstruction(instruction));
            } else {
                optimizedInstructions.add(instruction);
            }
        }
        return optimizedInstructions;
    }

    private boolean isOptimizableIndexAssignmentInstruction(TACInstruction instruction) {
        return instruction instanceof IndexAssignmentInstruction && isZero(instruction.getSecondReference());
    }

    private boolean isOptimizableIndexedValueInstruction(TACInstruction instruction) {
        return instruction instanceof IndexedValueInstruction && isZero(instruction.getThirdReference());
    }

    private boolean isZero(TACReference reference) {
        return reference instanceof TACLiteral && ((TACLiteral) reference).getValue() instanceof Integer &&
                (int) ((TACLiteral) reference).getValue() == 0;
    }

    private TACInstruction optimizeIndexAssignmentInstruction(TACInstruction instruction) {
        return new CopyInstruction((TACVariable) instruction.getFirstReference(), instruction.getThirdReference());
    }

    private TACInstruction optimizeIndexedValueInstruction(TACInstruction instruction) {
        return new CopyInstruction((TACVariable) instruction.getFirstReference(), instruction.getSecondReference());
    }
}
