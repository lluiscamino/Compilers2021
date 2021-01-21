package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public final class ArithmeticMultiply extends ArithmeticOperation {
    
    public ArithmeticMultiply(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("MUL", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
