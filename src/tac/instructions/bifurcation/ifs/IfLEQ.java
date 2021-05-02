package tac.instructions.bifurcation.ifs;

import tac.references.TACReference;
import tac.references.TACTag;

public final class IfLEQ extends IfInstruction {
    public IfLEQ(TACReference firstReference, TACReference secondReference, TACTag tag) {
        super(firstReference, secondReference, tag);
    }

    @Override
    public String toString() {
        return "if" + firstReference + " <= " + secondReference + " goto " + thirdReference;
    }
}
