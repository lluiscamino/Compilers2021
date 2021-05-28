package tac.instructions.array;

import tac.instructions.TACInstruction;
import tac.references.TACReference;

public abstract class ArrayInstruction extends TACInstruction {
    public ArrayInstruction(TACReference firstReference, TACReference secondReference) {
        super(firstReference, secondReference, null);
    }
}
