package tac.instructions.array;

import tac.instructions.TACInstruction;
import tac.references.TACReference;

public abstract class NewArrayInstruction extends TACInstruction {
    public NewArrayInstruction(TACReference firstReference, TACReference secondReference) {
        super(firstReference, secondReference, null);
    }

    public NewArrayInstruction(TACReference firstReference, TACReference secondReference, TACReference thirdReference) {
        super(firstReference, secondReference, thirdReference);
    }

    @Override
    public String toString() {
        return firstReference + " = new array[" + secondReference + "]";
    }
}
