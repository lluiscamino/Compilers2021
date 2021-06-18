package tac.instructions.io.print;

import assembly.AssemblyCodeGenerator;
import parser.symbols.types.Type;
import tac.references.TACLiteral;
import tac.references.TACReference;

public final class PrintArrayInstruction extends PrintInstruction {
    private final Type type;

    public PrintArrayInstruction(TACReference reference, Type type) {
        super(reference);
        this.type = type;
    }

    @Override
    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return new PrintStringInstruction(new TACLiteral("\"Array " + type + "\n\"")).toAssemblyCode(codeGenerator);
    }

    @Override
    public String toString() {
        return "printArray(" + firstReference + ")";
    }
}
