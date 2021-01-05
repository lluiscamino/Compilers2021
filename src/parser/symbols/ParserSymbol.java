package parser.symbols;

import dot.DOTizable;
import java.io.PrintWriter;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public abstract class ParserSymbol extends ComplexSymbol implements DOTizable {
    
    public ParserSymbol(String name) {
        super(name, 0);
    }
    
    public abstract void validate();
    
    @Override
    public abstract void toDot(StringBuilder out);
}
