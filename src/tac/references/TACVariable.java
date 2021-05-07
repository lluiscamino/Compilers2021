package tac.references;

public final class TACVariable extends TACReference {
    private final String identifier;

    public TACVariable(int id) {
        super(id);
        this.identifier = null;
    }

    public TACVariable(int id, String identifier) {
        super(id);
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TACVariable)) {
            return false;
        }
        return ((TACVariable) obj).id == id;
    }

    @Override
    public String toString() {
        return identifier != null ? identifier : "t" + id;
    }
}
