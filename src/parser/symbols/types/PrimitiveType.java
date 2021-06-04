package parser.symbols.types;

import dot.DOTizable;
import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.expressions.literals.BooleanLiteral;
import parser.symbols.expressions.literals.IntegerLiteral;
import parser.symbols.expressions.literals.StringLiteral;

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

    public Expression defaultExpression() {
        return switch (this) {
            case INT, UNKNOWN -> new IntegerLiteral(0, null);
            case BOOLEAN -> new BooleanLiteral(false, null);
            case STRING -> new StringLiteral("\"\"", null);
        };
    }

    public int sizeInBytes() {
        return switch (this) {
            case INT -> 8;
            case BOOLEAN -> 8;
            case STRING -> 8;
            case UNKNOWN -> 8;
        };
    }

    @Override
    public void toDot() {
        new DotNode(toString(), "", "filled", "");
    }
}
