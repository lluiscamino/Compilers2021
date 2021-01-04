package parser.symbols.statements;

import parser.symbols.ParserSymbol;

public abstract class Statement extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "STATEMENT";
    
    public Statement() {
        super(STRING_IDENTIFIER);
    }
}
