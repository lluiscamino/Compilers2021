package tac.instructions.binary;

import assembly.AssemblyCodeGenerator;
import tac.references.TACVariable;

public final class NotInstruction extends BinaryInstruction {
    public NotInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = not " + secondReference;
    }
}
