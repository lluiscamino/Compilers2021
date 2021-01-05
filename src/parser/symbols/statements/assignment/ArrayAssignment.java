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
        DotNode dotNode = new DotNode(buffer, "ASSGN - " + identifier, "", "filled", "#00a2ff");
        dotNode.addEdge(indexes);
        dotNode.addEdge(expression);
    }
}
