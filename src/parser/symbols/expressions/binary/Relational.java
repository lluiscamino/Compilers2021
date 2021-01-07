package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.RelationalOperatorType;
import parser.symbols.expressions.Expression;

public final class Relational extends Expression {
    private final Expression leftExpression, rightExpression;
    private final RelationalOperatorType operator;

    public Relational(
            Expression leftExpression, RelationalOperatorType operator, Expression rightExpression
    )
    {
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
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "relational", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(leftExpression, "leftExpr");
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression, "rightExpr");
    }
}
