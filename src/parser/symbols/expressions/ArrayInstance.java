package parser.symbols.expressions;

import dot.DotNode;
import parser.symbols.ArrayIndexes;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;

public final class ArrayInstance extends Expression {
    private final PrimitiveType primitiveType;
    private final ArrayIndexes indexes;
    
    public ArrayInstance(PrimitiveType primitiveType, ArrayIndexes indexes) {
        super(Type.getArray(primitiveType, indexes.numIndexes()), Mode.CONST, indexes.xleft);
        this.primitiveType = primitiveType;
        this.indexes = indexes;
    }

    @Override
    public void validate() {
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_INSTANCE", "", "filled", "#00a2ff");
        
        dotNode.addEdge(getType(), "type");
        dotNode.addEdge(indexes, "indexes");
    }
    
}
