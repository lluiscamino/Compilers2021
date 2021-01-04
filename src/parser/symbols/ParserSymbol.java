package parser.symbols;

import java.io.PrintWriter;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public abstract class ParserSymbol extends ComplexSymbol {
    private static int autoIncrementId = 0;
    
    public final int id;
    
    public ParserSymbol(String name) {
        super(name, autoIncrementId++);
        id = autoIncrementId;
    }
    
    public abstract void validate();
    
    public abstract void toDot(PrintWriter out);
}
