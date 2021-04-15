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
        DotNode dotNode = new DotNode("ARR_INSTANCE", "box", "filled", "#9077bf");
        
        dotNode.addEdge(getType(), "type");
        dotNode.addEdge(indexes, "indexes");
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
