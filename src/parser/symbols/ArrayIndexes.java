package parser.symbols;

import main.Compiler;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.List;

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
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        List<Expression> indexesList = indexes.toArrayList();

        indexesList.get(0).toTac();
        TACVariable prevVariable = variableGenerator.generate();
        addTACInstruction(new CopyInstruction(prevVariable, indexesList.get(0).getTacVariable()));
        for (int i = 0; i < indexesList.size() - 1; i++) {
            Expression nextIndex = indexesList.get(i + 1);
            nextIndex.toTac();
            TACVariable variable = variableGenerator.generate();
            addTACInstruction(new ProductInstruction(variable, prevVariable, null)); // t_x = i_x * d_(x + 1);
            TACVariable newVariable = variableGenerator.generate();
            addTACInstruction(new AddInstruction(newVariable, variable, nextIndex.getTacVariable()));
            prevVariable = newVariable;
        }
        offset = variableGenerator.generate();
        addTACInstruction(new ProductInstruction(offset, prevVariable, new TACLiteral(8)));
    }
}
