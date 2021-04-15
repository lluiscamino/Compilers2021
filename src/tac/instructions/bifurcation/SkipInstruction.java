package tac.instructions.bifurcation;

import tac.references.TACTag;

public final class SkipInstruction extends BifurcationInstruction {
    public SkipInstruction(TACTag tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return firstReference + ": skip";
    }
}
