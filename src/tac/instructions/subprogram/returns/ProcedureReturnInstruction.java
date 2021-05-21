package tac.instructions.subprogram.returns;

import assembly.AssemblyCodeGenerator;
import tac.references.TACSubprogram;

public final class ProcedureReturnInstruction extends ReturnInstruction {
    public ProcedureReturnInstruction(TACSubprogram subprogram) {
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
