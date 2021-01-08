package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class BinaryOr extends Expression {
    private final Expression leftExpression, rightExpression;
    
    public BinaryOr(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "BIN_OR", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "binaryOr", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(leftExpression, "leftExpression");
        dotNode.addEdgeIfNotNull(rightExpression, "rightExpression");
    }
}