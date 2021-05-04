package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACSubprogram;

public final class ReturnInstruction extends SubprogramInstruction {
    public ReturnInstruction(TACSubprogram subprogram) {
        super(subprogram);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "rtn " + firstReference;
    }
}
