package tac.instructions.arithmetic;

import tac.references.TACReference;
import tac.references.TACVariable;

public final class CopyInstruction extends ArithmeticInstruction {
    public CopyInstruction(TACVariable firstVariable, TACReference secondReference) {
        super(firstVariable, secondReference);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference;
    }
}
