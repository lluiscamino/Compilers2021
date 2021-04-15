package tac.instructions.bifurcation.ifs;

import tac.references.TACTag;
import tac.references.TACVariable;

public final class IfGEQ extends IfInstruction {
    public IfGEQ(TACVariable firstVariable, TACVariable secondVariable, TACTag tag) {
        super(firstVariable, secondVariable, tag);
    }

    @Override
    public String toString() {
        return "if" + firstReference + " >= " + secondReference + " goto " + thirdReference;
    }
}
