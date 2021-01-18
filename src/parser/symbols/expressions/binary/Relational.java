package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.RelationalOperatorType;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Relational extends Expression {
    private final Expression leftExpression, rightExpression;
    private final RelationalOperatorType operator;

    public Relational(Expression leftExpression, RelationalOperatorType operator, Expression rightExpression) {
        super(Type.getBoolean(), Mode.RESULT, leftExpression.xleft);
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        //mirar si las dos expresiones son del mismo tipo
        if (!(leftExpression.getType().equals(rightExpression.getType()))) {
            addSemanticError("No se puede hacer una operación lógica con un tipo que no sea " + Type.getBoolean());
        }

        leftExpression.validate();
        rightExpression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("RELATIONAL", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
