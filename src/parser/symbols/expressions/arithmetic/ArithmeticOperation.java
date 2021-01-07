package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.expressions.Expression;
import parser.symbols.operators.ArithmeticOperator;

public final class ArithmeticOperation extends Expression {
    private final Expression leftExpression, rightExpression;
    private final ArithmeticOperator operator;
    
    public ArithmeticOperation(Expression leftExpression, ArithmeticOperator operator, Expression rightExpression) {
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
        DotNode dotNode = new DotNode(buffer, "ARITH_OP", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "arithOp", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(leftExpression, "leftExpression");
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression, "rightExpression");
    }
}
