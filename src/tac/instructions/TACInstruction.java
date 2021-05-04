package tac.instructions;

import assembly.AssemblyCodeGenerator;
import tac.references.TACReference;

public abstract class TACInstruction {
    protected final TACReference firstReference, secondReference, thirdReference;

    public TACInstruction(TACReference firstReference, TACReference secondReference, TACReference thirdReference) {
        this.firstReference = firstReference;
        this.secondReference = secondReference;
        this.thirdReference = thirdReference;
    }

    public TACReference getFirstReference() {
        return firstReference;
    }

    public TACReference getSecondReference() {
        return secondReference;
    }

    public TACReference getThirdReference() {
        return thirdReference;
    }

    public abstract String toAssemblyCode(AssemblyCodeGenerator codeGenerator);

    @Override
    public abstract String toString();
}
