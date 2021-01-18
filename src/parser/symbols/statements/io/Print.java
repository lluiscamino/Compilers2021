package parser.symbols.statements.io;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public final class Print extends Statement {
    
    private final Expression expression;
    
    public Print(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        expression.validate(symbolTable);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("PRINT", "", "filled", "#00a2ff");
        dotNode.addEdge(expression, "expr");
    }
    
}
