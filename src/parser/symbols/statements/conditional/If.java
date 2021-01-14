package parser.symbols.statements.conditional;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public class If extends Statement {
    protected final Expression condition;
    protected final SymbolList<Statement> statements;

    public If(Expression condition, SymbolList<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "IF", "", "filled", "#00a2ff");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }
}
