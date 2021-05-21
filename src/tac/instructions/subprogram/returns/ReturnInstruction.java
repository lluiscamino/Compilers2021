package tac.instructions.subprogram.returns;

import tac.instructions.subprogram.SubprogramInstruction;
import tac.references.TACReference;

public abstract class ReturnInstruction extends SubprogramInstruction {
    public ReturnInstruction(TACReference reference) {
        super(reference);
    }

    public ReturnInstruction(TACReference firstReference, TACReference secondReference) {
        super(firstReference, secondReference);
    }
}
