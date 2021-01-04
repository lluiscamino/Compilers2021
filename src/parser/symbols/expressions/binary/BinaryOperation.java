package parser.symbols.expressions.binary;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class BinaryOperation extends Expression {
    private final Expression leftExpression, rightExpression;
    private final BinaryOperator operator;
    
    public BinaryOperation(Expression leftExpression, BinaryOperator operator, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
