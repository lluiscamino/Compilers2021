package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Negative extends Expression {
    private final Expression expression;
    
    public Negative(Expression expression) {
        super(Type.getInteger(), Mode.RESULT);
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "EXPR_NEG", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "negExpr", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(expression, "expr");
    }
    
}
