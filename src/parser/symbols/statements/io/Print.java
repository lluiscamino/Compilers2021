package parser.symbols.statements.io;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public final class Print extends Statement {
    
    private final Expression expression;
    
    public Print(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "PRINT", "", "filled", "#00a2ff");
        dotNode.addEdge(expression, "expr");
    }
    
}
