package tac.instructions.binary;

import tac.references.TACVariable;

public final class NotInstruction extends BinaryInstruction {
    public NotInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = not " + secondReference;
    }
}
