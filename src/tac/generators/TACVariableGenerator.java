package tac.generators;

import tac.references.TACVariable;

public class TACVariableGenerator extends TACReferenceGenerator {
    @Override
    public TACVariable generate() {
        return new TACVariable(nextId++);
    }
}
