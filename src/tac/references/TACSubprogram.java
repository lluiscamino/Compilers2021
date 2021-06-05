package tac.references;

public class TACSubprogram extends TACReference {
    public TACSubprogram(int id) {
        super(id);
    }

    @Override
    public int sizeInBytes() {
        throw new RuntimeException("TACSubprogram doesn't have an associated size");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TACSubprogram)) {
            return false;
        }
        return ((TACSubprogram) obj).id == id;
    }

    @Override
    public String toString() {
        return "s" + id;
    }
}
