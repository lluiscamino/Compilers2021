package tac.instructions.array;

import assembly.AssemblyCodeGenerator;
import tac.instructions.TACInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class ArrayLengthInstruction extends TACInstruction {
    public ArrayLengthInstruction(TACVariable variable, TACReference reference) {
        super(variable, reference, null);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = length(" + secondReference + ")";
    }
}
