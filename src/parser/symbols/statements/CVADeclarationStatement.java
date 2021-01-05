package parser.symbols.statements;

import parser.symbols.declarations.cva.CVADeclaration;

public final class CVADeclarationStatement extends Statement {
    private final CVADeclaration declaration;

    public CVADeclarationStatement(CVADeclaration declaration) {
        this.declaration = declaration;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        declaration.toDot(buffer);
    }
    
}
