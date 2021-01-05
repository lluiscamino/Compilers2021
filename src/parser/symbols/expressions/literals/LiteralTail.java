package parser.symbols.expressions.literals;

import parser.symbols.ParserSymbol;

public final class LiteralTail extends ParserSymbol {
    
    private static final String STRING_IDENTIFIER = "LIT_TAIL";
    
    private final Literal literal;
    private final LiteralTail literalTail;
    
    public LiteralTail(Literal literal, LiteralTail literalTail) {
        super(STRING_IDENTIFIER);
        this.literal = literal;
        this.literalTail = literalTail;
    }
    
    public LiteralTail() {
        super(STRING_IDENTIFIER);
        this.literal = null;
        this.literalTail = null;
    }
    
    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
