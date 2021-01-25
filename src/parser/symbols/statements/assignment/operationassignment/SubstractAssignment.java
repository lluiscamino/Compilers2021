package parser.symbols.statements.assignment.operationassignment;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public final class SubstractAssignment extends OperationAssignment {
    public SubstractAssignment(String identifier, Expression expression) {
        super(identifier, expression);
    }
    
    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("SUB_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "-=");
    }
}
