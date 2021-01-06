package parser.symbols.operators;

import java.io.PrintWriter;
import parser.symbols.ParserSymbol;

public class ArithmeticOperator extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARITH_OP";
    
    private enum Type {
        ADD, SUB, MUL, DIV, MOD;
    }
    
    private final Type type;
    
    private ArithmeticOperator(Type type) {
        super(STRING_IDENTIFIER);
        this.type = type;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARITH_OP", "", "filled ",  "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, type.toString(), "plaintext", "", "");
        }, "ident");
    }
    
    public static ArithmeticOperator getAdd() {
        return new ArithmeticOperator(Type.ADD);
    }
    
    public static ArithmeticOperator getSubstract() {
        return new ArithmeticOperator(Type.SUB);
    }
    
    public static ArithmeticOperator getMultiply() {
        return new ArithmeticOperator(Type.MUL);
    }
    
    public static ArithmeticOperator getDivide() {
        return new ArithmeticOperator(Type.DIV);
    }
    
    public static ArithmeticOperator getModulo() {
        return new ArithmeticOperator(Type.MOD);
    }

}
