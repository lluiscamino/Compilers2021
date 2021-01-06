package parser.symbols.operators;

import dot.DotNode;
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
        DotNode dotNode = new DotNode(buffer, "BIN_OP", "", "filled ",  "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, type.toString(), "plaintext", "", "");
        }, "ident");
        
    }
    
    public static BinaryOperator getAnd() {
        return new BinaryOperator(Type.AND);
    }
    
    public static BinaryOperator getOr() {
        return new BinaryOperator(Type.OR);
    }
    
}
