package tac.instructions.array;

import assembly.AssemblyCodeGenerator;
import tac.references.TACLiteral;
import tac.references.TACReference;

public final class NewStaticArrayInstruction extends NewArrayInstruction {
    public NewStaticArrayInstruction(TACReference firstReference, TACLiteral length, TACLiteral dataTypeSize) {
        super(firstReference, length, dataTypeSize);
    }

    public TACLiteral getLength() {
        return (TACLiteral) secondReference;
    }

    public TACLiteral getDataTypeSize() {
        return (TACLiteral) thirdReference;
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }
}
