package optimizers.global;

import optimizers.Optimizer;
import tac.instructions.TACInstruction;

import java.util.List;

public abstract class GlobalOptimizer implements Optimizer {
    protected final List<TACInstruction> unoptimizedInstructions;

    public GlobalOptimizer(List<TACInstruction> unoptimizedInstructions) {
        this.unoptimizedInstructions = unoptimizedInstructions;
    }
}
