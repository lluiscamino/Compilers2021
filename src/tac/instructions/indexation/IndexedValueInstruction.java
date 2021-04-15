package tac.instructions.indexation;

import tac.references.TACVariable;

public final class IndexedValueInstruction extends IndexationInstruction {
    public IndexedValueInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + "[" + thirdReference + "]";
    }
}
