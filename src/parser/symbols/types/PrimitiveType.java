package parser.symbols.types;

public enum PrimitiveType {
    INT("int"), BOOLEAN("boolean"), STRING("string");
    
    private final String value;
    
    PrimitiveType(String value) {
        this.value = value;
    }
    
    public static PrimitiveType get(String value) {
        for (PrimitiveType type : PrimitiveType.values()) {
            if (type.value.equals(value)) return type;
        }
        return null;
    }
}
