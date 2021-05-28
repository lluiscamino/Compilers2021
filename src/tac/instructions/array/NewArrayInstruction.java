package tac.instructions.array;

import assembly.AssemblyCodeGenerator;
import tac.references.TACLiteral;
import tac.references.TACVariable;

public final class NewArrayInstruction extends ArrayInstruction {
    public NewArrayInstruction(TACVariable variable, TACLiteral length) {
        super(variable, length);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = new array[" + secondReference + "]";
    }
}
