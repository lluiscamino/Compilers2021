package tac.references;

public final class TACLiteral extends TACReference {
    private final Object value;

    public TACLiteral(Object value) {
        super(0);
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TACLiteral)) {
            return false;
        }
        return ((TACLiteral) obj).value.equals(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
