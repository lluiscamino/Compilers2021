package parser.symbols.expressions.literals;

import java.io.PrintWriter;

public class BooleanLiteral extends Literal {
    
    public BooleanLiteral(boolean value) {
        super(value);
    }
    
    @Override
    public Boolean getValue() {
        return (boolean) literalValue;
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