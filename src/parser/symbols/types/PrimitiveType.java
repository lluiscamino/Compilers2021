package parser.symbols.types;

import dot.DOTizable;
import dot.DotNode;

public enum PrimitiveType implements DOTizable {
    INT("int"), BOOLEAN("boolean"), STRING("string"), UNKNOWN("UNKNOWN");
    
    private final String value;
    
    PrimitiveType(String value) {
        this.value = value;
    }
    
    public static PrimitiveType get(String value) {
        for (PrimitiveType type : PrimitiveType.values()) {
            if (type.value.equals(value)) return type;
        }
        return UNKNOWN;
    }

    public Object defaultValue() {
        return switch (this) {
            case INT, UNKNOWN -> 0;
            case BOOLEAN -> false;
            case STRING -> "\"\"";
        };
    }

    public int sizeInBytes() {
        return switch (this) {
            case INT -> 4;
            case BOOLEAN -> 1;
            case STRING -> value.length() * INT.sizeInBytes();
            case UNKNOWN -> 0;
        };
    }

    @Override
    public void toDot() {
        new DotNode(toString(), "", "filled", "");
    }
}
