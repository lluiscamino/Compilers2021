package parser.symbols.statements.assignment;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public class Assignment extends Statement {
    private final String identifier;
    private final Expression expression;
    
    public Assignment(String identifier, Expression expression) {
        this.identifier = identifier;
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
