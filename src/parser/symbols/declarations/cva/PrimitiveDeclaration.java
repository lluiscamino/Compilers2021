package parser.symbols.declarations.cva;

import dot.DotNode;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;


public final class PrimitiveDeclaration extends CVADeclaration {

    public PrimitiveDeclaration(DeclarationMode mode, PrimitiveType primitiveType,
            String identifier) {
        super(mode, new Type(primitiveType), identifier);
    }
    
    public PrimitiveDeclaration(DeclarationMode mode, PrimitiveType primitiveType,
            String identifier, Expression expression) {
        super(mode, new Type(primitiveType), identifier, expression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("DECL", "box", "filled", "#5280d6");
        
        dotNode.addEdge(mode, "mode");
        dotNode.addEdge(type, "type");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(expression, "value");
    }
    
}
