package tac.instructions.length;

import tac.instructions.TACInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

public abstract class LengthInstruction extends TACInstruction {
    public LengthInstruction(TACVariable firstVariable, TACReference secondReference) {
        super(firstVariable, secondReference, null);
    }
}
