package parser.symbols.declarations.cva;

import java.io.PrintWriter;
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
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
