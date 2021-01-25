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
    
    public SymbolList(T element) {
        super(STRING_IDENTIFIER, element.xleft);
        this.next = null;
        this.element = element;
    }
    
    public SymbolList(SymbolList<T> list, T element) {
        super(STRING_IDENTIFIER, element.xleft);
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
    
    public int size() {
        int counter = 0;
        SymbolList<T> node = this;
        while (node != null && node.element != null) {
            node = node.next;
            counter++;
        }
        return counter;
    }
    
    public List<T> toArrayList() {
        SymbolList<T> node = this;
        List<T> result = new ArrayList<>();
        while (node != null && node.element != null) {
            result.add(node.element);
            node = node.next;
        }
        return result;
    }

    @Override
    public void validate() {
        SymbolList<T> node = this;
        while (node != null && node.element != null) {
            node.element.validate();
            node = node.next;
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode(STRING_IDENTIFIER, "box", "filled", "#d4d4d4");
        
        dotNode.addEdgeIfNotNull(element);
        dotNode.addEdgeIfNotNull(next);
    }
}
