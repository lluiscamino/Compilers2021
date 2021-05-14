package tac.instructions.io.print;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public final class PrintArrayInstruction extends PrintInstruction {
    public PrintArrayInstruction(TACReference reference) {
        super(reference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "printArray(" + firstReference + ")";
    }
}
