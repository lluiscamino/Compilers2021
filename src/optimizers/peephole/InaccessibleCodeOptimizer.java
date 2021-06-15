package optimizers.peephole;

import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.special.InitProgramInstruction;

import java.util.ArrayList;
import java.util.List;

public final class InaccessibleCodeOptimizer extends PeepholeOptimizer {

    public InaccessibleCodeOptimizer(List<TACInstruction> unoptimizedInstructions) {
        super(unoptimizedInstructions);
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        boolean canBeRemoved = false;
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (instruction instanceof SkipInstruction) {
                canBeRemoved = false;
            }
            if (!canBeRemoved) {
                optimizedInstructions.add(instruction);
            }
            if (instruction instanceof InitProgramInstruction || instruction instanceof GotoInstruction) {
                canBeRemoved = true;
            }
        }
        return optimizedInstructions;
    }
}
