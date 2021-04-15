package tac.instructions.bifurcation;

import tac.instructions.TACInstruction;
import tac.references.TACReference;

public abstract class BifurcationInstruction extends TACInstruction {
    public BifurcationInstruction(TACReference firstReference) {
        super(firstReference, null, null);
    }

    public BifurcationInstruction(TACReference firstReference, TACReference secondReference, TACReference thirdReference) {
        super(firstReference, secondReference, thirdReference);
    }
}
