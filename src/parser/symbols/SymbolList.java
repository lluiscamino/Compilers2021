package parser.symbols;

import dot.DotNode;
import java.io.PrintWriter;

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
    public void toDot(PrintWriter out) {
        DotNode dotNode = new DotNode(this, STRING_IDENTIFIER, "box", "filled", "");
        if (element != null) {
            dotNode.addEdge(element);
        }
        if (list != null) {
            dotNode.addEdge(list);
        }
        
        dotNode.print(out);
        
        if (element != null) element.toDot(out);
        if (list != null) list.toDot(out);
    }
}
