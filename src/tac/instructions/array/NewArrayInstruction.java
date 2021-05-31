package tac.instructions.array;

import assembly.AssemblyCodeGenerator;
import tac.references.TACLiteral;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class NewArrayInstruction extends ArrayInstruction {
    public NewArrayInstruction(TACVariable variable, TACReference size) {
        super(variable, size);
    }

    public NewArrayInstruction(TACReference firstReference, TACLiteral length, TACReference dataTypeSize) {
        super(firstReference, length, dataTypeSize);
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
