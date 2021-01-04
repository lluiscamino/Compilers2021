package parser.symbols.statements;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class Return extends Statement {
    private final Expression expression;
    
    public Return(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
