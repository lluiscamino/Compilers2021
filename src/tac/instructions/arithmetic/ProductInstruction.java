package tac.instructions.arithmetic;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class ProductInstruction extends ArithmeticInstruction {
    public ProductInstruction(TACReference firstReference, TACReference secondReference, TACReference thirdReference) {
        super(firstReference, secondReference, thirdReference);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + " * " + thirdReference;
    }
}
