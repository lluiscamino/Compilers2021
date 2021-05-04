package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACSubprogram;

public final class PreambleInstruction extends SubprogramInstruction {
    public PreambleInstruction(TACSubprogram subprogram) {
        super(subprogram);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "pmb " + firstReference;
    }
}
