package parser.symbols.expressions.literals;

import java.io.PrintWriter;
import java.util.List;

public final class ArrayLiteral extends Literal {
    
    public ArrayLiteral(LiteralList literalsList) {
        super(literalsList);
    }
    
    @Override
    public List<Literal> getValue() {
        return (List<Literal>) literalValue;
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
