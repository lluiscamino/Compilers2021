package tac.instructions.bifurcation.ifs;

import tac.instructions.bifurcation.BifurcationInstruction;
import tac.references.TACTag;
import tac.references.TACVariable;

public abstract class IfInstruction extends BifurcationInstruction {
    public IfInstruction(TACVariable firstVariable, TACVariable secondVariable, TACTag tag) {
        super(firstVariable, secondVariable, tag);
    }
}
