package parser.symbols.expressions;

import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ParserSymbol;
import parser.symbols.types.Type;
import tac.references.TACVariable;

public abstract class Expression extends ParserSymbol {
    
    protected enum Mode {
        CONST, VAR, RESULT, UNKNOWN
    }
    
    private static final String STRING_IDENTIFIER = "EXPRESSION";
    
    private final Type type;
    private final Mode mode;
    protected TACVariable tacVariable;

    public Expression(Type type, Mode mode, Location location) {
        super(STRING_IDENTIFIER, location);
        this.type = type;
        this.mode = mode;
    }
    
    public Type getType() {
        return type;
    }

    public Mode getMode() {
        return mode;
    }

    public TACVariable getTacVariable() {
        return tacVariable;
    }
}
