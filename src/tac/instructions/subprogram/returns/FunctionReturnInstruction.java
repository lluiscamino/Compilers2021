package tac.instructions.subprogram.returns;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACSubprogram;

public final class FunctionReturnInstruction extends ReturnInstruction {
    public FunctionReturnInstruction(TACSubprogram subprogram, TACReference value) {
        super(subprogram, value);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "rtn " + firstReference + ": " + secondReference;
    }
}
