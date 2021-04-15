package parser.symbols;

import dot.DotNode;

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
    }

    @Override
    public void toDot() {
        new DotNode(String.valueOf(numDimensions), "", "filled", "");
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
