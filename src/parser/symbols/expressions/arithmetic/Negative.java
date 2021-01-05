package parser.symbols.expressions.arithmetic;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class Negative extends Expression {
    private final Expression expression;
    
    public Negative(Expression expression) {
        this.expression = expression;
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