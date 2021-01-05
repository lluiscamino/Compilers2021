package parser.symbols.operators;

import java.io.PrintWriter;
import parser.symbols.ParserSymbol;

public final class BinaryOperator extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "BIN_OP";
    
    private enum Type {
        AND, OR
    }
    
    private final Type type;
    
    private BinaryOperator(Type type) {
        super(STRING_IDENTIFIER);
        this.type = type;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static BinaryOperator getAnd() {
        return new BinaryOperator(Type.AND);
    }
    
    public static BinaryOperator getOr() {
        return new BinaryOperator(Type.OR);
    }
    
}
