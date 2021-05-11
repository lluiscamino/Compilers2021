package tac.generators;

import tac.references.TACTag;

public final class TACTagGenerator extends TACReferenceGenerator {
    private int nextIdDesc = Integer.MAX_VALUE;

    @Override
    public TACTag generate() {
        return new TACTag(nextId++);
    }

    public TACTag generate(String identifier) {
        return new TACTag(nextIdDesc--, identifier);
    }
}
