package tac.instructions.binary;

import tac.instructions.TACInstruction;
import tac.references.TACVariable;

public abstract class BinaryInstruction extends TACInstruction {
    public BinaryInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable, null);
    }

    public BinaryInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }
}
