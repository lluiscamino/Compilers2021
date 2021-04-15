package tac.instructions.indexation;

import tac.references.TACVariable;

public final class IndexAssignmentInstruction extends IndexationInstruction {
    public IndexAssignmentInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }

    @Override
    public String toString() {
        return firstReference + "[" + secondReference + "] = " + thirdReference;
    }
}
