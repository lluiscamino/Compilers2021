package tac.references;

public abstract class TACReference {
    protected final int id;

    public TACReference(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract String toString();
}
