package parser.symbols.declarations.cva;

import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;

public abstract class CVADeclaration extends Declaration {
    protected final Type type;
    protected final DeclarationMode mode;

    public CVADeclaration(DeclarationMode mode, Type type, String identifier) {
        super(identifier, mode.xleft);
        this.mode = mode;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public DeclarationMode getMode() {
        return mode;
    }
    
    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        if (!symbolTable.isInInitialScope() && !symbolTable.put(this)) {
            addSemanticError("Variable " + identifier + " ya definida");
        }
    }
}
