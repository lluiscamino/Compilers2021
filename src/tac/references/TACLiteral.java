package tac.references;

import parser.symbols.types.Type;

public final class TACLiteral extends TACReference {
    private final Object value;

    public TACLiteral(Object value) {
        super(0);
        this.value = value;
    }

    public Object getValue() {
        return value;
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

    public int compareTo(Object obj) {
        if (!(obj instanceof TACLiteral)) {
            return 0;
        }
        TACLiteral lit = (TACLiteral) obj;
        Type type = type();
        if (!type.equals(lit.type()) || type.isArray()) {
            return 0;
        }
        return switch (type.getPrimitiveType()) {
            case INT -> ((Integer) value).compareTo((Integer) lit.value);
            case BOOLEAN -> ((Boolean) value).compareTo((Boolean) lit.value);
            case STRING -> ((String) value).compareTo((String) lit.value);
            case UNKNOWN -> 0;
        };
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
