package tac.generators;

import tac.references.TACReference;

public abstract class TACReferenceGenerator {
    protected int nextId = 0;

    public abstract TACReference generate();
}
