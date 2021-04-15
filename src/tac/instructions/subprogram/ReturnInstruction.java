package tac.instructions.subprogram;

import tac.references.TACTag;

public final class ReturnInstruction extends SubprogramInstruction {
    public ReturnInstruction(TACTag tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "rtn " + firstReference;
    }
}
