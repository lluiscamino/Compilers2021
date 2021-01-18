package parser.symbols.statements.loop;

import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public abstract class Loop extends Statement {
    protected final Expression condition;
    protected final SymbolList<Statement> statements;

    public Loop(Expression condition, SymbolList<Statement> statements) {
        super(condition.xleft);
        this.condition = condition;
        this.statements = statements;
    }
    
}
