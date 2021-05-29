package tac.instructions.binary;

import tac.instructions.TACInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

public abstract class BinaryInstruction extends TACInstruction {
    public BinaryInstruction(TACVariable firstVariable, TACReference secondReference) {
        super(firstVariable, secondReference, null);
    }

    public BinaryInstruction(TACVariable firstVariable, TACReference secondReference, TACReference thirdReference) {
        super(firstVariable, secondReference, thirdReference);
    }
}
