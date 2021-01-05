package parser.symbols.expressions.literals;

import java.io.PrintWriter;

public final class IntegerLiteral extends Literal {
    
    public IntegerLiteral(int value) {
        super(value);
    }
    
    @Override
    public Integer getValue() {
        return (int) literalValue;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
