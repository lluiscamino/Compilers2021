package parser.symbols.statements.loop;

import java.util.List;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public abstract class Loop extends Statement {
    private final Expression condition;
    private final List<Statement> statements;

    public Loop(Expression condition, List<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }
    
}
