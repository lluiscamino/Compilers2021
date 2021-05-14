package tac.instructions.indexation;

import tac.instructions.TACInstruction;
import tac.references.TACReference;

public abstract class IndexationInstruction extends TACInstruction {
    public IndexationInstruction(TACReference firstReference, TACReference secondVariable, TACReference thirdReference) {
        super(firstReference, secondVariable, thirdReference);
    }
}
