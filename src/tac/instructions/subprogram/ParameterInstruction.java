package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public final class ParameterInstruction extends SubprogramInstruction {
    public ParameterInstruction(TACReference reference) {
        super(reference);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "param " + firstReference;
    }
}
