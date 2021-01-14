package parser.symbols;

import dot.DOTizable;
import java.io.PrintWriter;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import symboltable.SymbolTable;

public abstract class ParserSymbol extends ComplexSymbol implements DOTizable {
    
    public ParserSymbol(String name) {
        super(name, 0);
    }
    
    public abstract void validate(SymbolTable symbolTable);
    
    @Override
    public abstract void toDot(StringBuilder out);
}
