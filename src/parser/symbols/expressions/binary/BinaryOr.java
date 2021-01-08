package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public final class BinaryOr extends BinaryOperation {
    
    public BinaryOr(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "OR", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}