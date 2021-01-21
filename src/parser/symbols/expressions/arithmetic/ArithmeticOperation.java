package parser.symbols.expressions.arithmetic;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public abstract class ArithmeticOperation extends Expression {
    protected final Expression leftExpression, rightExpression;
    
    public ArithmeticOperation(Expression leftExpression, Expression rightExpression) {
        super(Type.getInteger(), Mode.RESULT, leftExpression.xleft);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    
    @Override
    public final void validate() {
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        if ((!leftType.isUnknown() && !leftType.isInteger()) || (!rightType.isUnknown() && !rightType.isInteger())) {
            addSemanticError("No se puede hacer una operación aritmética con un tipo que no sea " + Type.getInteger());
        }
        leftExpression.validate();
        rightExpression.validate();
    }
}
