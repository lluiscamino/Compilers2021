package parser.symbols.statements.conditional;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;

public class If extends Statement {
    protected final Expression condition;
    protected final SymbolList<Statement> statements;

    public If(Expression condition, SymbolList<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void validate() {
        if (!condition.getType().isBoolean()) {
            addSemanticError("La condición del bucle debe ser de tipo " + Type.getBoolean());
        }
        if (statements != null) {
            statements.validate();
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IF", "", "filled", "#00a2ff");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }
}
