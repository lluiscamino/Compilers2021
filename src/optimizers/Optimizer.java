package optimizers;

import tac.instructions.TACInstruction;

import java.util.List;

public interface Optimizer {
    List<TACInstruction> optimize();
}
