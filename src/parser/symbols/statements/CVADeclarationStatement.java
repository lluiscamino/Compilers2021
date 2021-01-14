package parser.symbols.statements;

import parser.symbols.declarations.cva.CVADeclaration;
import symboltable.SymbolTable;

public final class CVADeclarationStatement extends Statement {
    private final CVADeclaration declaration;

    public CVADeclarationStatement(CVADeclaration declaration) {
        this.declaration = declaration;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        declaration.validate(symbolTable);
    }

    @Override
    public void toDot(StringBuilder buffer) {
        declaration.toDot(buffer);
    }
    
}
