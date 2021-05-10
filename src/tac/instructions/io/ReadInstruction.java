package tac.instructions.io;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public final class ReadInstruction extends IOInstruction {
    public ReadInstruction(TACReference reference) {
        super(reference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = read()";
    }
}
