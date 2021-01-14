package parser.symbols.declarations;

import parser.symbols.ParserSymbol;

public abstract class Declaration extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "DECLARATION";
    
    protected final String identifier;
    
    public Declaration(String identifier) {
        super(STRING_IDENTIFIER);
        this.identifier = identifier;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
}
