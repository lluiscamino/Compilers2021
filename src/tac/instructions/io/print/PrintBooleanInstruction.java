package tac.instructions.io.print;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public final class PrintBooleanInstruction extends PrintInstruction {
    public PrintBooleanInstruction(TACReference reference) {
        super(reference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "printBoolean(" + firstReference + ")";
    }
}
