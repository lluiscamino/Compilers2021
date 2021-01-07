package parser.symbols.expressions.binary;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;
import parser.symbols.operators.BinaryOperator;

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
    public void toDot(StringBuilder buffer) {
         DotNode dotNode = new DotNode(buffer, "BIN_OP", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "binaryOp, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(leftExpression, "leftExpr");
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression, "rightExpr");
    }
}
