package parser.symbols.statements;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class Return extends Statement {
    private final Expression expression;
    
    public Return(Expression expression) {
        this.expression = expression;
    }
    
    public Type getExpressionType() {
        return expression.getType();
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        expression.validate(symbolTable);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("RETURN", "", "filled", "#00a2ff");
        dotNode.addEdge(expression);
    }
    
}
