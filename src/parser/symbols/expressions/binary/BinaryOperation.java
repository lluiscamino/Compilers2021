package parser.symbols.expressions.binary;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public abstract class BinaryOperation extends Expression {
    protected final Expression leftExpression, rightExpression;
    
    public BinaryOperation(Expression leftExpression, Expression rightExpression) {
        super(Type.getBoolean(), Mode.RESULT, leftExpression.xleft);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    
    @Override
    public final void validate() {
        //mirar si las dos expresiones son booleanas
        if (!(leftExpression.getType().isBoolean() && rightExpression.getType().isBoolean())) {
            addSemanticError("No se puede hacer una operación lógica con un tipo que no sea " + Type.getBoolean());
        }

        leftExpression.validate();
        rightExpression.validate();
    }
}
