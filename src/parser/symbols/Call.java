package parser.symbols;

import parser.symbols.expressions.*;
import java.io.PrintWriter;


public final class Call extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "CALL";
    
    private final String subProgramIdentifier;
    private final ExpressionList arguments;
    
    public Call(String subProgramIdentifier, ExpressionList arguments) {
        super(STRING_IDENTIFIER);
        this.subProgramIdentifier = subProgramIdentifier;
        this.arguments = arguments;
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
