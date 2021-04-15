package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public final class ArithmeticAdd extends ArithmeticOperation {

    public ArithmeticAdd(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ADD", "box", "filled", "#9077bf");

        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
