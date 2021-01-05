package parser.symbols.expressions.binary;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class Not extends Expression {
    private final Expression expression;
    
    public Not(Expression expression) {
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
