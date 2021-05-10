package tac.instructions.io;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public final class PrintInstruction extends IOInstruction {
    public PrintInstruction(TACReference reference) {
        super(reference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "print(" + firstReference + ")";
    }
}
