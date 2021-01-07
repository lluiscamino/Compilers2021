package parser.symbols.expressions.binary;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public final class Not extends Expression {
    private final Expression expression;
    
    public Not(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "NOT_EXPR", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "notExpr", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(expression, "expr");
    }
    
}
