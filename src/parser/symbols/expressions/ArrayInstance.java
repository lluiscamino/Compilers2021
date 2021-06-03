package parser.symbols.expressions;

import dot.DotNode;
import main.Compiler;
import parser.symbols.ArrayIndexes;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.ProductInstruction;
import tac.instructions.array.NewDynamicArrayInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.List;

public final class ArrayInstance extends Expression {
    private final PrimitiveType primitiveType;
    private final ArrayIndexes indexes;

    public ArrayInstance(PrimitiveType primitiveType, ArrayIndexes indexes) {
        super(Type.getArray(primitiveType, indexes.numIndexes()), Mode.CONST, indexes.xleft);
        this.primitiveType = primitiveType;
        this.indexes = indexes;
    }

    @Override
    public void validate() {
        indexes.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_INSTANCE", "box", "filled", "#9077bf");

        dotNode.addEdge(getType(), "type");
        dotNode.addEdge(indexes, "indexes");
    }

    @Override
    public void toTac() {
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        indexes.toTac();
        tacVariable = variableGenerator.generate(getType());
        TACVariable arraySizeInBytes = variableGenerator.generate(Type.getInteger());
        List<Expression> indexesArray = indexes.getIndexes().toArrayList();
        Expression firstIndex = indexesArray.get(0);
        PrimitiveType elementsType = indexesArray.size() == 1 ? primitiveType : PrimitiveType.INT;

        addTACInstruction(new ProductInstruction(arraySizeInBytes, firstIndex.getTacVariable(), new TACLiteral(elementsType.sizeInBytes())));
        addTACInstruction(new NewDynamicArrayInstruction(tacVariable, arraySizeInBytes));
        addTACInstruction(new IndexAssignmentInstruction(tacVariable, new TACLiteral(0), firstIndex.getTacVariable()));
    }
}
