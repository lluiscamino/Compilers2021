package parser.symbols.statements.io;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public final class Print extends Statement {
    
    private final Expression expression;
    
    public Print(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
