package tac.instructions.io;

import tac.instructions.TACInstruction;
import tac.references.TACReference;

public abstract class IOInstruction extends TACInstruction {
    public IOInstruction(TACReference reference) {
        super(reference, null, null);
    }
}