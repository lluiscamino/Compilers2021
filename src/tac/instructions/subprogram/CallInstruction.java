package tac.instructions.subprogram;

import tac.references.TACTag;

public final class CallInstruction extends SubprogramInstruction {
    public CallInstruction(TACTag tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "call " + firstReference;
    }
}
