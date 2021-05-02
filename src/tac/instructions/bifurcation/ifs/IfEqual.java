package tac.instructions.bifurcation.ifs;

import tac.references.TACReference;
import tac.references.TACTag;

public final class IfEqual extends IfInstruction {
    public IfEqual(TACReference firstReference, TACReference secondReference, TACTag tag) {
        super(firstReference, secondReference, tag);
    }

    @Override
    public String toString() {
        return "if " + firstReference + " = " + secondReference + " goto " + thirdReference;
    }
}
