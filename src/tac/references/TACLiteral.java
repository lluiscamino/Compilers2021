package tac.references;

import parser.symbols.types.Type;

public final class TACLiteral extends TACReference {
    private final Object value;

    public TACLiteral(Object value) {
        super(0);
        this.value = value;
    }

    public Type type() {
        if (value instanceof String) {
            return Type.getString();
        }
        if (value instanceof Integer) {
            return Type.getInteger();
        }
        if (value instanceof Boolean) {
            return Type.getBoolean();
        }
        return Type.getUnknown();
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
