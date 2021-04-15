package tac.references;

public final class TACTag extends TACReference {
    public TACTag(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "e" + id;
    }
}
