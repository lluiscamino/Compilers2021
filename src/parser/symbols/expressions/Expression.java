package parser.symbols.expressions;

import parser.symbols.ParserSymbol;
import parser.symbols.types.Type;

public abstract class Expression extends ParserSymbol {
    
    protected enum Mode {
        CONST, VAR, RESULT
    }
    
    private static final String STRING_IDENTIFIER = "EXPRESSION";
    
    private final Type type;
    private final Mode mode;
    
    public Expression(Type type, Mode mode) {
        super(STRING_IDENTIFIER);
        this.type = type;
        this.mode = mode;
    }
    
    public Type getType() {
        return type;
    }

    public Mode getMode() {
        return mode;
    }
    
}
