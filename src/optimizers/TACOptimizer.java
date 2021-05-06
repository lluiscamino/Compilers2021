package optimizers;

import tac.instructions.TACInstruction;

import java.util.List;

public interface TACOptimizer {
    List<TACInstruction> optimize();
}
