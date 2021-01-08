package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Not extends Expression {
    private final Expression expression;
    
    public Not(Expression expression) {
        super(Type.getBoolean(), Mode.RESULT);
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "NOT_EXPR", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(expression, "expr");
    }
    
}
