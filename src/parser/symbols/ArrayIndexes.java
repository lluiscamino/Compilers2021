package parser.symbols;

import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;

public final class ArrayIndexes extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARR_INDEX";
    
    private SymbolList<Expression> indexes;

    public ArrayIndexes(Expression lastIndex) {
        super(STRING_IDENTIFIER);
        this.indexes = new SymbolList<>();
        this.indexes = new SymbolList<>(indexes, lastIndex);
    }
    
    public void addIndex(Expression index) {
        indexes = new SymbolList<>(indexes, index);
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        indexes.toDot(buffer);
    }
    
}
