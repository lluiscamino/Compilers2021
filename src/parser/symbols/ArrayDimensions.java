package parser.symbols;

import java.io.PrintWriter;

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
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
