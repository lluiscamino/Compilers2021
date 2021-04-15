package tac.instructions.subprogram;

import tac.references.TACVariable;

public final class ComplexParameterInstruction extends SubprogramInstruction {
    public ComplexParameterInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    @Override
    public String toString() {
        return "param_c " + firstReference + "[" + secondReference + "]";
    }
}
