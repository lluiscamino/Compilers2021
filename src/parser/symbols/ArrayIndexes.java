package parser.symbols;

import java.io.PrintWriter;
import java.util.List;
import parser.symbols.expressions.Expression;

public final class ArrayIndexes extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARR_INDEX";
    
    private final List<Expression> indexes;

    public ArrayIndexes(List<Expression> indexes) {
        super(STRING_IDENTIFIER);
        this.indexes = indexes;
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
