package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class ArithmeticSubstract extends Expression {
    private final Expression leftExpression, rightExpression;
    
    public ArithmeticSubstract(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARITH_SUB", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "arithSub", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(leftExpression, "leftExpression");
        dotNode.addEdgeIfNotNull(rightExpression, "rightExpression");
    }
}