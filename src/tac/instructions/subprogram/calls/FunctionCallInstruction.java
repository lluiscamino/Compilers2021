package tac.instructions.subprogram.calls;

import assembly.AssemblyCodeGenerator;
import tac.references.TACSubprogram;
import tac.references.TACVariable;

public final class FunctionCallInstruction extends CallInstruction {
    public FunctionCallInstruction(TACVariable variable, TACSubprogram subprogram) {
        super(variable, subprogram);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = call " + secondReference;
    }
}
