package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.references.TACReference;
import tac.references.TACTag;

import java.util.ArrayList;
import java.util.List;

/**
 * Searches and optimizes adjacent branches. Turns a sequence of instructions like the following:
 * <pre>
 * if COND goto e1
 * goto e2
 * e1: skip
 * ...
 * e2: skip
 * </pre>
 * Into this:
 * <pre>
 * if !COND goto e2
 * e1: skip
 * ...
 * e2: skip
 * </pre>
 */
public final class AdjacentBranchesOptimizer implements TACOptimizer {
    private final List<TACInstruction> unoptimizedInstructions;
    private TACInstruction[] scopedInstructions = null;

    public AdjacentBranchesOptimizer(List<TACInstruction> unoptimizedInstructions) {
        this.unoptimizedInstructions = unoptimizedInstructions;
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        int line = 0;
        for (; line < unoptimizedInstructions.size() - 2; line++) {
            scopedInstructions = scopedInstructions(line);
            if (canBeOptimized()) {
                optimizedInstructions.add(oppositeIfInstruction());
                optimizedInstructions.add(newSkipInstruction());
                line += 2;
            } else {
                optimizedInstructions.add(scopedInstructions[0]);
            }
        }
        addRemainingInstructions(line, optimizedInstructions);
        return optimizedInstructions;
    }

    private TACInstruction[] scopedInstructions(int line) {
        return new TACInstruction[]{
                unoptimizedInstructions.get(line),
                unoptimizedInstructions.get(line + 1),
                unoptimizedInstructions.get(line + 2)
        };
    }

    private boolean canBeOptimized() {
        TACReference gotoTag = scopedInstructions[0].getThirdReference(), skipTag = scopedInstructions[2].getFirstReference();
        return scopedInstructions[0] instanceof IfInstruction && scopedInstructions[1] instanceof GotoInstruction &&
                scopedInstructions[2] instanceof SkipInstruction && gotoTag.equals(skipTag);
    }

    private IfInstruction oppositeIfInstruction() {
        IfInstruction ifInstruction = (IfInstruction) scopedInstructions[0];
        TACReference firstReference = scopedInstructions[0].getFirstReference();
        TACReference secondReference = scopedInstructions[0].getSecondReference();
        TACTag tag = (TACTag) scopedInstructions[1].getFirstReference();

        return ifInstruction.oppositeInstruction(firstReference, secondReference, tag);
    }

    private SkipInstruction newSkipInstruction() {
        return new SkipInstruction((TACTag) scopedInstructions[0].getThirdReference());
    }

    private void addRemainingInstructions(int line, List<TACInstruction> optimizedInstructions) {
        for (int i = line; i < unoptimizedInstructions.size(); i++) {
            optimizedInstructions.add(unoptimizedInstructions.get(i));
        }
    }
}
