package tac.generators;

import tac.references.TACTag;

public final class TACTagGenerator extends TACReferenceGenerator {
    @Override
    public TACTag generate() {
        return new TACTag(nextId++);
    }
}
