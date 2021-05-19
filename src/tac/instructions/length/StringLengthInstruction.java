package tac.instructions.length;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class StringLengthInstruction extends LengthInstruction {
    public StringLengthInstruction(TACVariable firstVariable, TACReference secondReference) {
        super(firstVariable, secondReference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = stringLength(" + secondReference + ")";
    }
}
