package parser.symbols.declarations.cva;

import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.types.PrimitiveType;

public abstract class CVADeclaration extends Declaration {
    protected final DeclarationMode mode;
    protected final PrimitiveType primitiveType;
    protected final String identifier;

    public CVADeclaration(DeclarationMode mode, PrimitiveType primitiveType, String identifier) {
        this.mode = mode;
        this.primitiveType = primitiveType;
        this.identifier = identifier;
    }
}
