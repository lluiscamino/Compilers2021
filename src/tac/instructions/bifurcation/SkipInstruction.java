package tac.instructions.bifurcation;

import assembly.AssemblyCodeGenerator;
import tac.references.TACTag;

public final class SkipInstruction extends BifurcationInstruction {
    public SkipInstruction(TACTag tag) {
        super(tag);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + ": skip";
    }
}
