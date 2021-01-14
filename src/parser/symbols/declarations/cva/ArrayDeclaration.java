package parser.symbols.declarations.cva;

import dot.DotNode;
import parser.symbols.ArrayDimensions;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class ArrayDeclaration extends CVADeclaration {
    private final ArrayDimensions dimensions;

    public ArrayDeclaration(DeclarationMode mode, PrimitiveType primitiveType, ArrayDimensions dimensions, String identifier) {
        super(mode, new Type(primitiveType, dimensions), identifier);
        this.dimensions = dimensions;
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARR_DECL", "box", "filled", "");
        
        dotNode.addEdge(mode, "mode");
        dotNode.addEdge(type, "type");
    }
    
}
