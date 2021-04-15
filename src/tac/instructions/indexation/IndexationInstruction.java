package tac.instructions.indexation;

import tac.instructions.TACInstruction;
import tac.references.TACVariable;

public abstract class IndexationInstruction extends TACInstruction {
    public IndexationInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }
}
