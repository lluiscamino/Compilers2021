package tac.instructions.subprogram.calls;

import assembly.AssemblyCodeGenerator;
import tac.references.TACSubprogram;

public final class ProcedureCallInstruction extends CallInstruction {
    public ProcedureCallInstruction(TACSubprogram subprogram) {
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
