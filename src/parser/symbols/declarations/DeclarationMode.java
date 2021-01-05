package parser.symbols.declarations;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.ParserSymbol;

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
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        String label = mode.toString();
        DotNode dotNode = new DotNode(this, label, "", "filled", "");
        dotNode.print(out);
    }
    
    public static DeclarationMode getConstant() {
        return new DeclarationMode(Mode.CONST);
    }
    
    public static DeclarationMode getVariable() {
        return new DeclarationMode(Mode.VAR);
    }
    
}
