package tac.instructions.subprogram;

import assembly.AssemblyCodeGenerator;
import tac.references.TACTag;

public final class CallInstruction extends SubprogramInstruction {
    public CallInstruction(TACTag tag) {
        super(tag);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "call " + firstReference;
    }
}
