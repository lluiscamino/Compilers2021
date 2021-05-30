package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfInstruction;
import tac.references.TACTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Optimizes needless goto instruction. For example, turns a sequence of instructions like this:
 * <pre>
 *     if COND goto e1
 *     ...
 *     e1: skip
 *     goto e2
 * </pre>
 * Into the following:
 * <pre>
 *     if COND goto e2
 *     ...
 *     e1: skip
 *     goto e2
 * </pre>
 */
public final class NeedlessGotosOptimizer extends TACOptimizer {

    public NeedlessGotosOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        Map<TACTag, TACInstruction> tagsPosition = buildTagsPositionMap();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (instruction instanceof GotoInstruction) {
                tryGotoInstructionOptimization(tagsPosition, instruction);
            } else if (instruction instanceof IfInstruction) {
                tryIfInstructionOptimization(tagsPosition, instruction);
            }
            optimizedInstructions.add(instruction);
        }
        return optimizedInstructions;
    }

    private Map<TACTag, TACInstruction> buildTagsPositionMap() {
        Map<TACTag, TACInstruction> tagsPosition = new HashMap<>();
        for (int i = 0; i < unoptimizedInstructions.size() - 1; i++) {
            TACInstruction instruction = unoptimizedInstructions.get(i),
                    nextInstruction = unoptimizedInstructions.get(i + 1);
            if (instruction instanceof SkipInstruction) {
                tagsPosition.put((TACTag) instruction.getFirstReference(), nextInstruction);
            }
        }
        return tagsPosition;
    }

    private void tryGotoInstructionOptimization(Map<TACTag, TACInstruction> tagsPosition, TACInstruction instruction) {
        TACInstruction gotoInstruction = tagsPosition.get(instruction.getFirstReference());
        if (gotoInstruction instanceof GotoInstruction) {
            instruction.setFirstReference(gotoInstruction.getFirstReference());
        }
    }

    private void tryIfInstructionOptimization(Map<TACTag, TACInstruction> tagsPosition, TACInstruction instruction) {
        TACInstruction gotoInstruction = tagsPosition.get(instruction.getThirdReference());
        if (gotoInstruction instanceof GotoInstruction) {
            instruction.setThirdReference(gotoInstruction.getFirstReference());
        }
    }
}
