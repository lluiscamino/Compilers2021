package parser.symbols.statements.assignment;

import dot.DotNode;
import parser.symbols.ArrayIndexes;
import parser.symbols.expressions.Expression;

public final class ArrayAssignment extends Assignment {
    private final ArrayIndexes indexes;
    
    public ArrayAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, expression);
        this.indexes = indexes;
    }
    
    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARR_ASSGN", "", "filled", "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(indexes, "indexes");
        dotNode.addEdge(expression, "expr");
    }
}
