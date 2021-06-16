package optimizers.local;

import optimizers.Optimizer;
import optimizers.utils.BasicBloc;
import tac.instructions.TACInstruction;

import java.util.Collection;
import java.util.List;

public abstract class LocalOptimizer implements Optimizer {
    protected final List<TACInstruction> unoptimizedInstructions;
    protected final Collection<BasicBloc> basicBlocs;

    public LocalOptimizer(List<TACInstruction> unoptimizedInstructions, Collection<BasicBloc> basicBlocs) {
        this.unoptimizedInstructions = unoptimizedInstructions;
        this.basicBlocs = basicBlocs;
    }
}
