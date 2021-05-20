package tac.instructions.bifurcation.ifs.specialtypes;

import assembly.AssemblyCodeGenerator;
import tac.instructions.bifurcation.ifs.IfDiff;
import tac.instructions.bifurcation.ifs.IfInstruction;
import tac.references.TACReference;
import tac.references.TACTag;

public final class IfDiffString extends IfDiff {
    public IfDiffString(TACReference firstReference, TACReference secondReference, TACTag tag) {
        super(firstReference, secondReference, tag);
    }

    @Override
    public IfInstruction oppositeInstruction(TACReference firstReference, TACReference secondReference, TACTag tag) {
        return new IfEqualString(firstReference, secondReference, tag);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }
}
