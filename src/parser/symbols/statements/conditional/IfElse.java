package parser.symbols.statements.conditional;

import java.io.PrintWriter;
import java.util.List;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public final class IfElse extends If {

    private final List<Statement> elseStatements;

    public IfElse(Expression condition, List<Statement> statements, List<Statement> elseStatements) {
        super(condition, statements);
        this.elseStatements = elseStatements;
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
