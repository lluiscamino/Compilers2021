package parser.symbols;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class ArrayIndexes extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARR_INDEX";
    
    private SymbolList<Expression> indexes;

    public ArrayIndexes(Expression lastIndex) {
        super(STRING_IDENTIFIER, lastIndex.xleft);
        this.indexes = new SymbolList<>();
        this.indexes = new SymbolList<>(indexes, lastIndex);
    }

    public ArrayIndexes(SymbolList<Expression> indexes) {
        super(STRING_IDENTIFIER, null);
        this.indexes = indexes;
    }

    public SymbolList<Expression> getIndexes() {
        return indexes;
    }

    public void addIndex(Expression index) {
        indexes = new SymbolList<>(indexes, index);
    }
    
    public int numIndexes() {
        return indexes.size();
    }

    @Override
    public void validate() {
        indexes.validate();
        for (Expression index : indexes.toArrayList()) {
            Type indexType = index.getType();
            if (!indexType.isUnknown() && !indexType.isInteger()) {
                addSemanticError("Los índices de un array deben ser de tipo " + Type.getInteger() + ", no de tipo " + index.getType());
            }
        }
    }

    @Override
    public void toDot() {
        indexes.toDot();
    }

    @Override
    public void toTac() {
        indexes.toTac();
    }
}
