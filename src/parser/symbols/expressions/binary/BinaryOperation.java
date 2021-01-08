package parser.symbols.expressions.binary;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public abstract class BinaryOperation extends Expression {
    protected final Expression leftExpression, rightExpression;
    
    public BinaryOperation(Expression leftExpression, Expression rightExpression) {
        super(Type.getBoolean(), Mode.RESULT);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
