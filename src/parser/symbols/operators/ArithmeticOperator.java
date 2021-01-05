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
        throw new UnsupportedOperationException("Not supported yet.");
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
