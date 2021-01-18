package parser.symbols;

import dot.DotNode;
import symboltable.SymbolTable;

public final class ArrayDimensions extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARR_DIM";
    
    private int numDimensions = 1;

    public ArrayDimensions() {
        super(STRING_IDENTIFIER);
    }
    
    public void addNewDimension() {
        numDimensions++;
    }

    public int size() {
        return numDimensions;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
    }

    @Override
    public void toDot() {
        new DotNode(String.valueOf(numDimensions), "", "filled", "#ffffff");
    }
    
}
