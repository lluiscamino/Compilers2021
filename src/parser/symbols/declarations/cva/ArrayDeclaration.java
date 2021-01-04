package parser.symbols.declarations.cva;

import java.io.PrintWriter;
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
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
