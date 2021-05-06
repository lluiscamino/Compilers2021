package tac.references;

public final class TACVariable extends TACReference {
    public TACVariable(int id) {
        super(id);
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
        return "t" + id;
    }
}
