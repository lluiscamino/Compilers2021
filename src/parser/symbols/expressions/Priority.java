package parser.symbols.expressions;

import dot.DotNode;

public final class Priority extends Expression {
    private final Expression expression;
    
    public Priority(Expression expression) {
        super(expression.getType(), expression.getMode());
        this.expression = expression;
    }

    @Override
    public void validate() {
        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("EXPR_PRIO", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
            new DotNode("expr", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(expression, "expr");
    }
    
}
