package parser;

public enum RelationalOperatorType {
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
}
