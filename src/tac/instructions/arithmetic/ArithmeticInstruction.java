package tac.instructions.arithmetic;

import tac.instructions.TACInstruction;
import tac.references.TACVariable;

public abstract class ArithmeticInstruction extends TACInstruction {
    public ArithmeticInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable, null);
    }

    public ArithmeticInstruction(TACVariable firstVariable, TACVariable secondVariable, TACVariable thirdVariable) {
        super(firstVariable, secondVariable, thirdVariable);
    }
}
