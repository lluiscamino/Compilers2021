package parser.symbols.statements.loop;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import main.Compiler;
import symboltable.SymbolTable;

public final class WhileLoop extends Loop {

    public WhileLoop(Expression condition, SymbolList<Statement> statements) {
        super(condition, statements);
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        Type condType = condition.getType();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición del bucle debe ser de tipo " + Type.getBoolean() + ", no de tipo " + condType);
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
        DotNode dotNode = new DotNode("WHILE", "box", "filled", "#5280d6");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
