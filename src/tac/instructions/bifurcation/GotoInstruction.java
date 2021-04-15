package tac.instructions.bifurcation;

import tac.references.TACTag;

public final class GotoInstruction extends BifurcationInstruction {
    public GotoInstruction(TACTag tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "goto " + firstReference;
    }
}
