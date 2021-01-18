package parser.symbols.statements;

import parser.symbols.declarations.cva.CVADeclaration;

public final class CVADeclarationStatement extends Statement {
    private final CVADeclaration declaration;

    public CVADeclarationStatement(CVADeclaration declaration) {
        this.declaration = declaration;
    }

    @Override
    public void validate() {
        declaration.validate();
    }

    @Override
    public void toDot() {
        declaration.toDot();
    }
    
}
