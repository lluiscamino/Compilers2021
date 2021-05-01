package tac.generators;

import tac.references.TACSubprogram;

public final class TACSubprogramGenerator extends TACReferenceGenerator {
    @Override
    public TACSubprogram generate() {
        return new TACSubprogram(nextId++);
    }
}
