package tac.instructions.io.print;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public final class PrintStringInstruction extends PrintInstruction {
    public PrintStringInstruction(TACReference reference) {
        super(reference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "printString(" + firstReference + ")";
    }
}
