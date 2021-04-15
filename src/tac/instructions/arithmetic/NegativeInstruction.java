package tac.instructions.arithmetic;

import tac.references.TACVariable;

public final class NegativeInstruction extends ArithmeticInstruction {
    public NegativeInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    @Override
    public String toString() {
        return firstReference + " = - " + secondReference;
    }
}
