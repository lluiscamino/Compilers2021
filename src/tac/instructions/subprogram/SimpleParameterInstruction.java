package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACTag;

public final class SimpleParameterInstruction extends SubprogramInstruction {
    public SimpleParameterInstruction(TACTag tag) {
        super(tag);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "param_s " + firstReference;
    }
}
