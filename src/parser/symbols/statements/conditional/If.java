package parser.symbols.statements.conditional;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;

public class If extends Statement {
    protected final Expression condition;
    protected final SymbolList<Statement> statements;

    public If(Expression condition, SymbolList<Statement> statements) {
        super(condition.xleft);
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        Type condType = condition.getType();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición del bucle debe ser de tipo " + Type.getBoolean());
        }
        symbolTable.enterBlock();
        condition.validate();
        if (statements != null) {
            statements.validate();
        }
        symbolTable.exitBlock();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IF", "", "filled", "#5280d6");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
