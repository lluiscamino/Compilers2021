package optimizers;

import tac.instructions.TACInstruction;

import java.util.List;

public abstract class TACOptimizer {
    protected final List<TACInstruction> unoptimizedInstructions;

    public TACOptimizer(List<TACInstruction> unoptimizedInstructions) {
        this.unoptimizedInstructions = unoptimizedInstructions;
    }

    public abstract List<TACInstruction> optimize();
}
