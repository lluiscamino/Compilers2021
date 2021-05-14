package tac.instructions.indexation;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class IndexAssignmentInstruction extends IndexationInstruction {
    public IndexAssignmentInstruction(TACVariable firstVariable, TACReference secondReference, TACReference thirdReference) {
        super(firstVariable, secondReference, thirdReference);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + "[" + secondReference + "] = " + thirdReference;
    }
}
