package parser.symbols.declarations.cva;

import dot.DotNode;
import parser.symbols.ArrayDimensions;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.types.PrimitiveType;

public final class ArrayDeclaration extends CVADeclaration {
    private final ArrayDimensions dimensions;

    public ArrayDeclaration(DeclarationMode mode, PrimitiveType primitiveType, ArrayDimensions dimensions, String identifier) {
        super(mode, primitiveType, identifier);
        this.dimensions = dimensions;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARR_DECL", "box", "filled", "");
        
        dotNode.addEdge(mode, "mode");
        dotNode.addEdge(primitiveType, "type");
        dotNode.addEdge(dimensions, "dimensions");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
    }
    
}
