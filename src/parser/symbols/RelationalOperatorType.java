package parser.symbols;

import dot.DOTizable;
import dot.DotNode;

public enum RelationalOperatorType implements DOTizable {
    LESS("<"), GREATER(">"), LEQ("<="), GEQ(">="), EQUAL("=="), DIFF("!=");
    
    private final String value;
    
    RelationalOperatorType(String value) {
        this.value = value;
    }
    
    public static RelationalOperatorType get(String value) {
        for (RelationalOperatorType type : RelationalOperatorType.values()) {
            if (type.value.equals(value)) return type;
        }
        return null;
    }

    @Override
    public void toDot() {
        new DotNode(toString(), "plaintext", "filled", "");
    }
}
