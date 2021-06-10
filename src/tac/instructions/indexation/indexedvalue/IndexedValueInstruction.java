package tac.instructions.indexation.indexedvalue;

import assembly.AssemblyCodeGenerator;
import tac.instructions.indexation.IndexationInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

public class IndexedValueInstruction extends IndexationInstruction {
    public IndexedValueInstruction(TACVariable firstVariable, TACVariable secondVariable, TACReference thirdReference) {
        super(firstVariable, secondVariable, thirdReference);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + "[" + thirdReference + "]";
    }
}
