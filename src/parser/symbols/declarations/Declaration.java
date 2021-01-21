package parser.symbols.declarations;

import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ParserSymbol;

public abstract class Declaration extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "DECLARATION";
    
    protected final String identifier;
    
    public Declaration(String identifier, Location location) {
        super(STRING_IDENTIFIER, location);
        this.identifier = identifier;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    @Override
    public abstract String toString();
    
}
