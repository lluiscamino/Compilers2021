package tac.instructions.subprogram;

import tac.references.TACTag;

public final class PreambleInstruction extends SubprogramInstruction {
    public PreambleInstruction(TACTag tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "pmb " + firstReference;
    }
}
