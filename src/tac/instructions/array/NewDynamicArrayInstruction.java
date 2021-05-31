package tac.instructions.array;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class NewDynamicArrayInstruction extends NewArrayInstruction {
    public NewDynamicArrayInstruction(TACVariable variable, TACReference size) {
        super(variable, size);
    }

    public TACReference getSize() {
        return secondReference;
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }
}
