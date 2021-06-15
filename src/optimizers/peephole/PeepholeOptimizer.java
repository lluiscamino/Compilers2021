package optimizers.peephole;

import optimizers.Optimizer;
import tac.instructions.TACInstruction;

import java.util.List;

public abstract class PeepholeOptimizer implements Optimizer {
    protected final List<TACInstruction> unoptimizedInstructions;

    public PeepholeOptimizer(List<TACInstruction> unoptimizedInstructions) {
        this.unoptimizedInstructions = unoptimizedInstructions;
    }

    public abstract List<TACInstruction> optimize();
}
