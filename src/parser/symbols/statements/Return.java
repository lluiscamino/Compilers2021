package parser.symbols.statements;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public final class Return extends Statement {
    private final Expression expression;
    
    public Return(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "RETURN", "", "filled", "#00a2ff");
        dotNode.addEdge(expression);
    }
    
}
