package tac.instructions.indexation.indexassignment;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;
import tac.references.TACVariable;

public final class IndexAssignmentToZeroInstruction extends IndexAssignmentInstruction {
    public IndexAssignmentToZeroInstruction(TACVariable firstVariable, TACReference secondReference) {
        super(firstVariable, secondReference, null);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + "[0] = " + secondReference;
    }
}
