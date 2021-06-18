package tac.instructions.io.print;

import assembly.AssemblyCodeGenerator;
import tac.references.TACLiteral;
import tac.references.TACReference;

public final class PrintArrayInstruction extends PrintInstruction {
    public PrintArrayInstruction(TACReference reference) {
        super(reference);
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return new PrintStringInstruction(new TACLiteral("Array")).toAssemblyCode(codeGenerator);
    }

    @Override
    public String toString() {
        return "printArray(" + firstReference + ")";
    }
}
