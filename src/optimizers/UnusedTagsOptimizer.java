package optimizers;

import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfInstruction;
import tac.references.TACTag;

import java.util.*;

public final class UnusedTagsOptimizer extends TACOptimizer {
    public UnusedTagsOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        Set<TACTag> usedTags = new HashSet<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (instruction instanceof IfInstruction) {
                usedTags.add((TACTag) instruction.getThirdReference());
            } else if (instruction instanceof GotoInstruction) {
                usedTags.add((TACTag) instruction.getFirstReference());
            }
        }
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (!(instruction instanceof SkipInstruction) || usedTags.contains(instruction.getFirstReference())) {
                optimizedInstructions.add(instruction);
            }
        }
        return optimizedInstructions;
    }
}
