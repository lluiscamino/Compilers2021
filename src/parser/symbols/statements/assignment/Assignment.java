package parser.symbols.statements.assignment;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;

public class Assignment extends Statement {
    protected final String identifier;
    protected final Expression expression;
    
    public Assignment(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ASSGN", "", "filled", "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "expr");
    }
    
}
