package parser.symbols.types;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ArrayDimensions;
import parser.symbols.ParserSymbol;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.expressions.literals.ArrayLiteral;

public final class Type extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "TYPE";
    
    private final PrimitiveType primitiveType;
    private final ArrayDimensions dimensions;

    public Type(PrimitiveType primitiveType) {
        super(STRING_IDENTIFIER);
        this.primitiveType = primitiveType;
        this.dimensions = null;
    }

    public Type(PrimitiveType primitiveType, ArrayDimensions dimensions) {
        super(STRING_IDENTIFIER);
        this.primitiveType = primitiveType;
        this.dimensions = dimensions;
    }
    
    public Type(PrimitiveType primitiveType, Location location) {
        super(STRING_IDENTIFIER, location);
        this.primitiveType = primitiveType;
        this.dimensions = null;
    }

    public Type(PrimitiveType primitiveType, ArrayDimensions dimensions, Location location) {
        super(STRING_IDENTIFIER, location);
        this.primitiveType = primitiveType;
        this.dimensions = dimensions;
    }

    public PrimitiveType getPrimitiveType() {
        return primitiveType;
    }

    public ArrayDimensions getDimensions() {
        return dimensions;
    }
    
    public boolean isUnknown() {
        return primitiveType == PrimitiveType.UNKNOWN;
    }
    
    public boolean isInteger() {
        return !isArray() && primitiveType == PrimitiveType.INT;
    }
    
    public boolean isBoolean() {
        return !isArray() && primitiveType == PrimitiveType.BOOLEAN;
    }
    
    public boolean isString() {
        return !isArray() && primitiveType == PrimitiveType.STRING;
    }
    
    public boolean isIntegerArray() {
        return isArray() && primitiveType == PrimitiveType.INT;
    }
    
    public boolean isBooleanArray() {
        return isArray() && primitiveType == PrimitiveType.BOOLEAN;
    }
    
    public boolean isStringArray() {
        return isArray() && primitiveType == PrimitiveType.STRING;
    }
    
    public boolean isArray() {
        return dimensions != null;
    }

    public Object defaultValue() {
        if (!isArray()) {
            return primitiveType.defaultValue();
        }
        return switch (primitiveType) {
            case INT, UNKNOWN -> new int[]{};
            case BOOLEAN -> new boolean[]{};
            case STRING -> new String[]{};
        };
    }

    public Expression defaultExpression() {
        if (!isArray()) {
            return primitiveType.defaultExpression();
        }
        return new ArrayLiteral(new SymbolList<>(), null);
    }
    
    public boolean equals(Type t) {
        if (primitiveType != t.primitiveType) return false;
        if (isArray() != t.isArray()) return false;
        return !isArray() || dimensions.size() == t.dimensions.size();
    }

    @Override
    public void validate() {
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("TYPE", "box", "filled", "#f5568c");
        
        dotNode.addEdge(primitiveType, "prim");
        if (isArray()) {
            dotNode.addEdge(dimensions, "dimensions");
        }
    }

    @Override
    public void toTac() {}
    
    @Override
    public String toString() {
        String result = primitiveType.toString();
        if (isArray()) {
            result += "_ARR Dimensions:" + dimensions.size();
        }
        return result;
    }
    
    public static Type getUnknown() {
        return new Type(PrimitiveType.UNKNOWN);
    }
    
    public static Type getInteger() {
        return new Type(PrimitiveType.INT);
    }
    
    public static Type getBoolean() {
        return new Type(PrimitiveType.BOOLEAN);
    }
    
    public static Type getString() {
        return new Type(PrimitiveType.STRING);
    }
    
    public static Type getArray(PrimitiveType primType, int numDimensions) {
        if (numDimensions <= 0) return new Type(primType);
        ArrayDimensions dimensions = new ArrayDimensions();
        while (dimensions.size() < numDimensions) {
            dimensions.addNewDimension();
        }
        return new Type(primType, dimensions);
    }
}
