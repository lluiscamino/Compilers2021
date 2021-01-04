package parser.symbols.statements.loop;

import java.util.List;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public abstract class Loop extends Statement {
    private final Expression condition;
    private final SymbolList<Statement> statements;

    public Loop(Expression condition, SymbolList<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }
    
}
