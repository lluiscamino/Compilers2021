package tac.instructions.arithmetic;

import assembly.AssemblyCodeGenerator;
import tac.references.TACVariable;

public final class NegativeInstruction extends ArithmeticInstruction {
    public NegativeInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = - " + secondReference;
    }
}
