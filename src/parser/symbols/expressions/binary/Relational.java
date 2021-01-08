package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.RelationalOperatorType;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Relational extends Expression {
    private final Expression leftExpression, rightExpression;
    private final RelationalOperatorType operator;

    public Relational(Expression leftExpression, 
            RelationalOperatorType operator, Expression rightExpression) {
        super(Type.getBoolean(), Mode.RESULT);
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "RELATIONAL", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
