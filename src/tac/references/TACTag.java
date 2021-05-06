package tac.references;

public final class TACTag extends TACReference {
    public TACTag(int id) {
        super(id);
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
        return "e" + id;
    }
}
