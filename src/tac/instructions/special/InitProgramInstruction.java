package tac.instructions.special;

import assembly.AssemblyCodeGenerator;
import tac.instructions.TACInstruction;

public final class InitProgramInstruction extends TACInstruction {

    public InitProgramInstruction() {
        super(null, null, null);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "init";
    }
}
