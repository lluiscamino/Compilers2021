package tac.instructions.subprogram.calls;

import tac.instructions.subprogram.SubprogramInstruction;
import tac.references.TACSubprogram;
import tac.references.TACVariable;

public abstract class CallInstruction extends SubprogramInstruction {

    public CallInstruction(TACSubprogram subprogram) {
        super(subprogram);
    }

    public CallInstruction(TACVariable variable, TACSubprogram subprogram) {
        super(variable, subprogram);
    }
}
