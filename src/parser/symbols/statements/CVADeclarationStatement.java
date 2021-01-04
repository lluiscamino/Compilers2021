package parser.symbols.statements;

import java.io.PrintWriter;

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
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
