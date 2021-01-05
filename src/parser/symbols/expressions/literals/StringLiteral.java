package parser.symbols.expressions.literals;

import java.io.PrintWriter;

public class StringLiteral extends Literal {
    
    public StringLiteral(String value) {
        super(value);
    }
    
    @Override
    public String getValue() {
        return (String) literalValue;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}