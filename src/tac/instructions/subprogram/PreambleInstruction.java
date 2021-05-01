package tac.instructions.subprogram;

import tac.references.TACSubprogram;

public final class PreambleInstruction extends SubprogramInstruction {
    public PreambleInstruction(TACSubprogram subprogram) {
        super(subprogram);
    }

    @Override
    public String toString() {
        return "pmb " + firstReference;
    }
}
