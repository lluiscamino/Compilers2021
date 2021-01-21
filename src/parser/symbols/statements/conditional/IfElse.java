package parser.symbols.statements.conditional;

import dot.DotNode;
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
        super.validate();
        if (elseStatements != null) {
            elseStatements.validate();
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IF", "", "filled", "#5280d6");
        
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
        dotNode.addEdgeIfNotNull(elseStatements, "else-stmts");
    }
}
