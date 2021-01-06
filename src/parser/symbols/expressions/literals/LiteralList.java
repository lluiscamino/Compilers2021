package parser.symbols.expressions.literals;

import dot.DotNode;
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
        DotNode dotNode = new DotNode(buffer, STRING_IDENTIFIER, "LIT_LIST", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "lit_list", "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(literal, "lit");
        dotNode.addEdgeIfNotNull(literalList, "litList");
    }
    
}
