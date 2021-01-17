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

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, toString(), "", "filled", "");
    }
}
