package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACSubprogram;

public final class CallInstruction extends SubprogramInstruction {
    public CallInstruction(TACSubprogram subprogram) {
        super(subprogram);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "call " + firstReference;
    }
}
