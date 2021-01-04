package parser.symbols.statements.assignment;

import parser.symbols.ArrayIndexes;
import parser.symbols.expressions.Expression;

public final class ArrayAssignment extends Assignment {
    private final ArrayIndexes indexes;
    
    public ArrayAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, expression);
        this.indexes = indexes;
    }
}
