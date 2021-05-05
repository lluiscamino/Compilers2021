package parser.symbols;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import tac.references.TACVariable;

public final class ArrayIndexes extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARR_INDEX";
    
    private SymbolList<Expression> indexes;
    private TACVariable offset;

    public ArrayIndexes(Expression lastIndex) {
        super(STRING_IDENTIFIER, lastIndex.xleft);
        this.indexes = new SymbolList<>();
        this.indexes = new SymbolList<>(indexes, lastIndex);
    }

    public TACVariable getOffset() {
        return offset;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
