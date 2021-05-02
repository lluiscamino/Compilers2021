package tac.instructions.bifurcation.ifs;

import tac.instructions.bifurcation.BifurcationInstruction;
import tac.references.TACReference;
import tac.references.TACTag;

public abstract class IfInstruction extends BifurcationInstruction {
    public IfInstruction(TACReference firstReference, TACReference secondReference, TACTag tag) {
        super(firstReference, secondReference, tag);
    }
}
