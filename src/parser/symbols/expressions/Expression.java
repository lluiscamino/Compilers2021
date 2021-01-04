package parser.symbols.expressions;

import parser.symbols.ParserSymbol;

public abstract class Expression extends ParserSymbol {
    
    private static final String STRING_IDENTIFIER = "EXPRESSION";
    
    public Expression() {
        super(STRING_IDENTIFIER);
    }
    
}
