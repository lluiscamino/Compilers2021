package tac.instructions.binary;

import tac.references.TACVariable;

public final class AndInstruction extends BinaryInstruction {
    public AndInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + " and " + thirdReference;
    }
}
