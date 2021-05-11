package tac.instructions.subprogram;

import tac.instructions.TACInstruction;
import tac.references.TACReference;

public abstract class SubprogramInstruction extends TACInstruction {
    public SubprogramInstruction(TACReference reference) {
        super(reference, null, null);
    }

    public SubprogramInstruction(TACReference firstReference, TACReference secondReference) {
        super(firstReference, secondReference, null);
    }
}
