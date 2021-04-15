package tac.instructions.bifurcation.ifs;

import tac.references.TACTag;
import tac.references.TACVariable;

public final class IfLEQ extends IfInstruction {
    public IfLEQ(TACVariable firstVariable, TACVariable secondVariable, TACTag tag) {
        super(firstVariable, secondVariable, tag);
    }

    @Override
    public String toString() {
        return "if" + firstReference + " <= " + secondReference + " goto " + thirdReference;
    }
}
