package parser.symbols.declarations.cva;

import dot.DotNode;
import parser.symbols.ArrayDimensions;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;

public final class ArrayDeclaration extends CVADeclaration {
    private final ArrayDimensions dimensions;

    public ArrayDeclaration(DeclarationMode mode, PrimitiveType primitiveType, 
            ArrayDimensions dimensions, String identifier) {
        super(mode, new Type(primitiveType, dimensions), identifier);
        this.dimensions = dimensions;
    }
    
     public ArrayDeclaration(DeclarationMode mode, PrimitiveType primitiveType, 
            ArrayDimensions dimensions, String identifier, Expression expression) {
        super(mode, new Type(primitiveType, dimensions), identifier, expression);
        this.dimensions = dimensions;
    }

    public ArrayDimensions getDimensions() {
        return dimensions;
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_DECL", "box", "filled", "");
        
        dotNode.addEdge(mode, "mode");
        dotNode.addEdge(type, "type");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(expression, "value");
    }
    
}
