package tac.instructions.bifurcation.ifs.specialtypes;

import assembly.AssemblyCodeGenerator;
import tac.instructions.bifurcation.ifs.IfEqual;
import tac.instructions.bifurcation.ifs.IfInstruction;
import tac.references.TACReference;
import tac.references.TACTag;

public final class IfEqualString extends IfEqual {
    public IfEqualString(TACReference firstReference, TACReference secondReference, TACTag tag) {
        super(firstReference, secondReference, tag);
    }

    @Override
    public IfInstruction oppositeInstruction(TACReference firstReference, TACReference secondReference, TACTag tag) {
        return new IfDiffString(firstReference, secondReference, tag);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }
}
