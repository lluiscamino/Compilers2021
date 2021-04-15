package tac.references;

public final class TACVariable extends TACReference {
    public TACVariable(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "t" + id;
    }
}
