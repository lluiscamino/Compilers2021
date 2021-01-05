package parser.symbols.declarations.cva;

import dot.DotNode;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.types.PrimitiveType;


public final class PrimitiveDeclaration extends CVADeclaration {

    public PrimitiveDeclaration(DeclarationMode mode, PrimitiveType primitiveType, String identifier) {
        super(mode, primitiveType, identifier);
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "Declaration", "box", "filled", "");
        
        dotNode.addEdge(mode, "mode");
        dotNode.addEdge(primitiveType, "type");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
    }
    
}
