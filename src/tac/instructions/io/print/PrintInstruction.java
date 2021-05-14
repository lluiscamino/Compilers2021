package tac.instructions.io.print;

import tac.instructions.io.IOInstruction;
import tac.references.TACReference;

public abstract class PrintInstruction extends IOInstruction {
    public PrintInstruction(TACReference reference) {
        super(reference);
    }
}
