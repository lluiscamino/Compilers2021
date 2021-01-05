package parser.symbols;

import dot.DotNode;

public final class SymbolList<T extends ParserSymbol> extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "LIST";
    
    private final SymbolList<T> list;
    private final T element;

    public SymbolList() {
        super(STRING_IDENTIFIER);
        list = null;
        element = null;
    }
    
    public SymbolList(SymbolList<T> list, T element) {
        super(STRING_IDENTIFIER);
        this.list = list;
        this.element = element;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, STRING_IDENTIFIER, "box", "filled", "#d4d4d4");
        
        dotNode.addEdgeIfNotNull(element);
        dotNode.addEdgeIfNotNull(list);
    }
}
