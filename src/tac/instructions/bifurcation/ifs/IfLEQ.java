package tac.instructions.bifurcation.ifs;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACTag;

public final class IfLEQ extends IfInstruction {
    public IfLEQ(TACReference firstReference, TACReference secondReference, TACTag tag) {
        super(firstReference, secondReference, tag);
    }

    @Override
    public IfInstruction oppositeInstruction(TACReference firstReference, TACReference secondReference, TACTag tag) {
        return new IfGreater(firstReference, secondReference, tag);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return "if " + firstReference + " <= " + secondReference + " goto " + thirdReference;
    }
}
