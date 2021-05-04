package tac.instructions.binary;

import assembly.AssemblyCodeGenerator;
import tac.references.TACVariable;

public final class AndInstruction extends BinaryInstruction {
    public AndInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + " and " + thirdReference;
    }
}
