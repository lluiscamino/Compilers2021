package parser.symbols.expressions;

import dot.DotNode;
import parser.symbols.types.Type;

public final class Conditional extends Expression {
    private final Expression condition, leftExpression, rightExpression;
    
    public Conditional(Expression condition, Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), Mode.RESULT, condition.xleft);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.condition = condition;
    }

    @Override
    public void validate() {
        Type condType = condition.getType();
        Type leftExprType = leftExpression.getType();
        Type rightExprType = rightExpression.getType();
        boolean unknownType = leftExprType.isUnknown() || rightExprType.isUnknown();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición de la expresión condicional debe ser de tipo " + Type.getBoolean() + ", no de tipo " + condType);
        }
        if (!unknownType && !leftExprType.equals(rightExprType)) {
            addSemanticError("Los tipos de las expresiones de una operación condicional deben ser iguales");
        }
        condition.validate();
        leftExpression.validate();
        rightExpression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("COND", "box", "filled", "#9077bf");
        
        dotNode.addEdge(condition, "cond");
        dotNode.addEdge(leftExpression);
        dotNode.addEdge(rightExpression);
    }
    
}
