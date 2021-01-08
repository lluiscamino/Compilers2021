package parser.symbols.expressions.arithmetic;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public abstract class ArithmeticOperation extends Expression {
    protected final Expression leftExpression, rightExpression;
    
    public ArithmeticOperation(Expression leftExpression, Expression rightExpression) {
        super(Type.getInteger(), Mode.RESULT);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
