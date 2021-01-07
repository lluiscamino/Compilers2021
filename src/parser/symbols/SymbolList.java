package parser.symbols;

import dot.DotNode;
import java.util.ArrayList;
import java.util.List;

public final class SymbolList<T extends ParserSymbol> extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "LIST";
    
    private final SymbolList<T> next;
    private final T element;

    public SymbolList() {
        super(STRING_IDENTIFIER);
        next = null;
        element = null;
    }
    
    public SymbolList(SymbolList<T> list, T element) {
        super(STRING_IDENTIFIER);
        this.next = list;
        this.element = element;
    }
    
    public SymbolList<T> next() {
        return next;
    }
    
    public boolean isLast() {
        return next == null;
    }
    
    public T getElement() {
        return element;
    }
    
    public T[] toArray() {
        SymbolList<T> node = this;
        List<T> result = new ArrayList<>();
        while (node != null) {
            result.add(node.element);
            node = node.next;
        }
        return (T[]) result.toArray();
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, STRING_IDENTIFIER, "box", "filled", "#d4d4d4");
        
        dotNode.addEdgeIfNotNull(element);
        dotNode.addEdgeIfNotNull(next);
    }
}
