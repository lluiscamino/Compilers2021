package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;

public final class BinaryOr extends BinaryOperation {
    
    public BinaryOr(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("OR", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
