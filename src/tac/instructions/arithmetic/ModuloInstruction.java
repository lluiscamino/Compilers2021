package tac.instructions.arithmetic;

import tac.references.TACVariable;

public final class ModuloInstruction extends ArithmeticInstruction {
    public ModuloInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + " % " + thirdReference;
    }
}