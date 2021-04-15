package tac.instructions.binary;

import tac.references.TACVariable;

public final class OrInstruction extends BinaryInstruction {
    public OrInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + " or " + thirdReference;
    }
}
