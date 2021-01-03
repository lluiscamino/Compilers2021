package parser.symbols;

import java.io.PrintWriter;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public abstract class ParserSymbol extends ComplexSymbol {
    private static int autoIncrementId = 0;
    
    protected final int id;
    
    public ParserSymbol(String name, Number value) {
        super(name, autoIncrementId++, value);
        id = autoIncrementId;
    }
    
    public abstract void validate();
    
    public abstract void toDot(PrintWriter out);
}