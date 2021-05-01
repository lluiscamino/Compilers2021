package tac.references;

public class TACSubprogram extends TACReference {
    public TACSubprogram(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "s" + id;
    }
}
