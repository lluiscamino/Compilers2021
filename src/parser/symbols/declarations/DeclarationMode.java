package parser.symbols.declarations;

import dot.DotNode;
import parser.symbols.ParserSymbol;
import symboltable.SymbolTable;

public final class DeclarationMode extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "DECL_MODE";
    
    private enum Mode {
        CONST, VAR
    }
    
    private final Mode mode;
    
    private DeclarationMode(Mode mode) {
        super(STRING_IDENTIFIER);
        this.mode = mode;
    }
    
    public boolean isConstant() {
        return mode == Mode.CONST;
    }
    
    public boolean isVariable() {
        return mode == Mode.VAR;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
    }

    @Override
    public void toDot() {
        new DotNode(mode.toString(), "", "filled", "");
    }
    
    public static DeclarationMode getConstant() {
        return new DeclarationMode(Mode.CONST);
    }
    
    public static DeclarationMode getVariable() {
        return new DeclarationMode(Mode.VAR);
    }
    
}
