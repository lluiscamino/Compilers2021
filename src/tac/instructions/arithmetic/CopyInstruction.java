package tac.instructions.arithmetic;

import tac.references.TACVariable;

public final class CopyInstruction extends ArithmeticInstruction {
    public CopyInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference;
    }
}
