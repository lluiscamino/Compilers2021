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
        DotNode dotNode = new DotNode(buffer, STRING_IDENTIFIER, "LIT_TAIL", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "lit_tail", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(literal, "lit");
        dotNode.addEdgeIfNotNull(literalTail, "litTail");
    }
    
}
