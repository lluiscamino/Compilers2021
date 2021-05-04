package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACVariable;

public final class ComplexParameterInstruction extends SubprogramInstruction {
    public ComplexParameterInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "param_c " + firstReference + "[" + secondReference + "]";
    }
}
