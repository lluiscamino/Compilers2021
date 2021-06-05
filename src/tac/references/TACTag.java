package tac.references;

public final class TACTag extends TACReference {
    private final String identifier;

    public TACTag(int id) {
        super(id);
        this.identifier = null;
    }

    public TACTag(int id, String identifier) {
        super(id);
        this.identifier = identifier;
    }

    public boolean isMain() {
        return identifier != null && identifier.equals("t_main");
    }

    @Override
    public int sizeInBytes() {
        throw new RuntimeException("TACTag doesn't have an associated size");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TACTag)) {
            return false;
        }
        return ((TACTag) obj).id == id;
    }

    @Override
    public String toString() {
        return identifier != null ? identifier : "e" + id;
    }
}
