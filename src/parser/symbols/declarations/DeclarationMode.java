package parser.symbols.declarations;

import java.io.PrintWriter;
import parser.symbols.ParserSymbol;

public final class DeclarationMode extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "DECL_MODE";
    private static final int CONST = 0;
    private static final int VAR = 1;
    
    private final int mode;
    
    private DeclarationMode(int mode) {
        super(STRING_IDENTIFIER);
        this.mode = mode;
    }
    
    public boolean isConstant() {
        return mode == CONST;
    }
    
    public boolean isVariable() {
        return mode == VAR;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static DeclarationMode getConstant() {
        return new DeclarationMode(CONST);
    }
    
    public static DeclarationMode getVariable() {
        return new DeclarationMode(VAR);
    }
    
}
