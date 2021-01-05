package parser.symbols.expressions.literals;

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
    public void toDot(StringBuilder buffer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
