package parser.symbols.statements.conditional;

import java.io.PrintWriter;
import java.util.List;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public final class IfElse extends If {

    private final SymbolList<Statement> elseStatements;

    public IfElse(Expression condition, SymbolList<Statement> statements, SymbolList<Statement> elseStatements) {
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
