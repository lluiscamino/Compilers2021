package tac.instructions.indexation.indexassignment;

import assembly.AssemblyCodeGenerator;
import tac.instructions.indexation.IndexationInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

public class IndexAssignmentInstruction extends IndexationInstruction {
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
