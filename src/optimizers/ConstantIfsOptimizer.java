package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.references.TACLiteral;
import tac.references.TACTag;

import java.util.ArrayList;
import java.util.List;

/**
 * Searches and optimizes constant ifs. Turns a sequence like the following:
 * <pre>
 *     if 0 = 0 goto e3
 * </pre>
 * Into this:
 * <pre>
 *     goto e3
 * </pre>
 * And a sequence like this:
 * <pre>
 *     if 0 = -1 goto e3
 *     ...
 * </pre>
 * Into this:
 * <pre>
 *     ...
 * </pre>
 */
public final class ConstantIfsOptimizer extends TACOptimizer {
    public ConstantIfsOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (canBeOptimized(instruction)) {
                if (conditionIsTrue((IfInstruction) instruction)) {
                    optimizedInstructions.add(new GotoInstruction((TACTag) instruction.getThirdReference()));
                }
            } else {
                optimizedInstructions.add(instruction);
            }
        }
        return optimizedInstructions;
    }

    private boolean canBeOptimized(TACInstruction instruction) {
        return instruction instanceof IfInstruction &&
                instruction.getFirstReference() instanceof TACLiteral &&
                instruction.getSecondReference() instanceof TACLiteral;
    }

    private boolean conditionIsTrue(IfInstruction ifInstruction) {
        TACLiteral firstLiteral = (TACLiteral) ifInstruction.getFirstReference(), secondLiteral = (TACLiteral) ifInstruction.getSecondReference();
        int comparison = firstLiteral.compareTo(secondLiteral);
        if (ifInstruction instanceof IfEqual) {
            return comparison == 0;
        } else if (ifInstruction instanceof IfDiff) {
            return comparison != 0;
        } else if (ifInstruction instanceof IfGEQ) {
            return comparison >= 0;
        } else if (ifInstruction instanceof IfGreater) {
            return comparison > 0;
        } else if (ifInstruction instanceof IfLEQ) {
            return comparison <= 0;
        } else if (ifInstruction instanceof IfLess) {
            return comparison < 0;
        }
        return false;
    }
}
