package parser.symbols.expressions;

import java.io.PrintWriter;

public final class Priority extends Expression {
    private final Expression expression;
    
    public Priority(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "EXPR_PRIO", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "expr", "plaintext", "", "");
        }, "ident");
    }
    
}
