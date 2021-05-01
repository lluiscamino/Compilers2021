package tac.instructions.subprogram;

import tac.references.TACSubprogram;

public final class ReturnInstruction extends SubprogramInstruction {
    public ReturnInstruction(TACSubprogram subprogram) {
        super(subprogram);
    }

    @Override
    public String toString() {
        return "rtn " + firstReference;
    }
}
