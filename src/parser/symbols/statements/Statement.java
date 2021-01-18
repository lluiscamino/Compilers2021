package parser.symbols.statements;

import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ParserSymbol;

public abstract class Statement extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "STATEMENT";
    
    public Statement(Location location) {
        super(STRING_IDENTIFIER, location);
    }
}
