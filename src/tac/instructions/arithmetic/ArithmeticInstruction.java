package tac.instructions.arithmetic;

import tac.instructions.TACInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

public abstract class ArithmeticInstruction extends TACInstruction {
    public ArithmeticInstruction(TACVariable firstVariable, TACReference secondReference) {
        super(firstVariable, secondReference, null);
    }

    public ArithmeticInstruction(TACReference firstReference, TACReference secondReference, TACReference thirdReference) {
        super(firstReference, secondReference, thirdReference);
    }
}
