package tac.instructions.subprogram;

import tac.references.TACTag;

public final class SimpleParameterInstruction extends SubprogramInstruction {
    public SimpleParameterInstruction(TACTag tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "param_s " + firstReference;
    }
}
