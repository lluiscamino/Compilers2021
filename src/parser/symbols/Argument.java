package parser.symbols;

import java.io.PrintWriter;
import parser.symbols.types.Type;

public final class Argument extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARGUMENT";
    private final Type type;
    private final String identifier;

    public Argument(Type type, String identifier) {
        super(STRING_IDENTIFIER);
        this.type = type;
        this.identifier = identifier;
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
