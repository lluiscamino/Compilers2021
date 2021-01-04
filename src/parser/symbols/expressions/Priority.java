package parser.symbols.expressions;

import java.io.PrintWriter;

public final class Priority extends Expression {
    private final Expression expression;
    
    public Priority(Expression expression) {
        this.expression = expression;
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
