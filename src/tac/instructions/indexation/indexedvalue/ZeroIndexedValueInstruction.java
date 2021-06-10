package tac.instructions.indexation.indexedvalue;

import assembly.AssemblyCodeGenerator;
import tac.references.TACVariable;

public final class ZeroIndexedValueInstruction extends IndexedValueInstruction {
    public ZeroIndexedValueInstruction(TACVariable firstVariable, TACVariable secondVariable) {
        super(firstVariable, secondVariable, null);
    }

    public String toAssemblyCode(AssemblyCodeGenerator codeGenerator) {
        return codeGenerator.generate(this);
    }

    @Override
    public String toString() {
        return firstReference + " = " + secondReference + "[0]";
    }
}
