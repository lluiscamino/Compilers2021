package parser.symbols.statements.conditional;

import java.io.PrintWriter;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public class If extends Statement {
    protected final Expression condition;
    protected final SymbolList<Statement> statements;

    public If(Expression condition, SymbolList<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
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
