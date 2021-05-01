package tac.instructions.subprogram;

import tac.instructions.TACInstruction;
import tac.references.TACReference;
import tac.references.TACTag;
import tac.references.TACVariable;

public abstract class SubprogramInstruction extends TACInstruction {
    public SubprogramInstruction(TACReference reference) {
        super(reference, null, null);
    }

    public SubprogramInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable, null);
    }
}
