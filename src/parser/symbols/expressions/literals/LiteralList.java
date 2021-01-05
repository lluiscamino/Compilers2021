package parser.symbols.expressions.literals;

import java.io.PrintWriter;
import parser.symbols.ParserSymbol;

public final class LiteralList extends ParserSymbol {
    
    private static final String STRING_IDENTIFIER = "LIT_LIST";
    
    private final Literal literal;
    private final LiteralTail literalsList;
    
    public LiteralList(Literal literal, LiteralTail literalsList) {
        super(STRING_IDENTIFIER);
        this.literal = literal;
        this.literalsList = literalsList;
    }
    
    public LiteralList() {
        super(STRING_IDENTIFIER);
        this.literal = null;
        this.literalsList = null;
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
