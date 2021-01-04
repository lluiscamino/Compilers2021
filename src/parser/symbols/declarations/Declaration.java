package parser.symbols.declarations;

import parser.symbols.ParserSymbol;

public abstract class Declaration extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "DECLARATION";
    
    public Declaration() {
        super(STRING_IDENTIFIER);
    }
    
}
