package parser.symbols.statements.assignment;

import dot.DotNode;
import main.Compiler;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.instructions.indexation.indexassignment.IndexAssignmentInstruction;
import tac.instructions.indexation.indexedvalue.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

import java.util.List;

public class ArrayAssignment extends Assignment {

    protected final ArrayIndexes indexes;

    public ArrayAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, expression);
        this.indexes = indexes;
    }

    @Override
    public void validate() {
        try {
            CVADeclaration declaration = getIdentifierDeclaration();
            checkDeclarationExists(declaration);
            checkDeclarationIsVariable(declaration);
            checkDeclarationIsArray(declaration);
            checkTypesAreEqual(declaration);
        } catch (Exception ex) {
            addSemanticError(ex.getMessage());
        } finally {
            indexes.validate();
            expression.validate();
        }
    }

    protected CVADeclaration getIdentifierDeclaration() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        return symbolTable.getCVA(identifier);
    }

    protected void checkDeclarationIsArray(CVADeclaration declaration) throws Exception {
        if (!(declaration instanceof ArrayDeclaration)) {
            throw new Exception(identifier + " no es un ARRAY");
        }
    }

    @Override
    protected void checkTypesAreEqual(CVADeclaration declaration) throws Exception {
        Type expectedType = getExpectedType((ArrayDeclaration) declaration);
        Type exprType = expression.getType();
        if (expectedType == null) {
            throw new Exception("El array " + identifier + " no tiene tantas dimensiones");
        } else if (!exprType.isUnknown() && !expectedType.isUnknown() && !(exprType.equals(expectedType))) {
            throw new Exception("No se puede asignar un valor de tipo " + exprType + " a una variable de tipo " + expectedType);
        }
    }

    protected Type getExpectedType(ArrayDeclaration declaration) {
        int numIndexes = indexes.numIndexes();
        int numArrayDimensions = declaration.getDimensions().size();
        if (numIndexes > numArrayDimensions) {
            return null;
        }
        int numDimensions = numArrayDimensions - numIndexes;
        PrimitiveType primType = declaration.getType().getPrimitiveType();
        return Type.getArray(primType, numDimensions);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> new DotNode(identifier, "plaintext", "filled", ""), "ident");
        dotNode.addEdge(indexes, "indexes");
        dotNode.addEdge(expression, "expr");
    }

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        ArrayDeclaration declaration = (ArrayDeclaration) getIdentifierDeclaration();
        int declarationNumDimensions = declaration.getDimensions().size();
        VariablesTable.VariableInfo variableInfo = variablesTable.get(identifier);
        TACVariable variable = variableInfo.getTacVariable();
        TACVariable newVariable = variableGenerator.generate(variableInfo.getType());
        TACVariable realIndex = variableGenerator.generate(Type.getInteger());
        indexes.toTac();
        List<Expression> indexesList = indexes.getIndexes().toArrayList();
        TACVariable lastIndex = indexesList.get(indexesList.size() - 1).getTacVariable();

        addTACInstruction(new CopyInstruction(newVariable, variable));
        PrimitiveType primitiveType = expression.getType().getPrimitiveType();
        for (int i = 0; i < indexesList.size() - 1; i++) {
            Expression index = indexesList.get(i);
            addTACInstruction(new ProductInstruction(realIndex, index.getTacVariable(), new TACLiteral(Type.getArray(primitiveType, (declarationNumDimensions - i - 1)).sizeInBytes())));
            addTACInstruction(new AddInstruction(realIndex, realIndex, new TACLiteral(Type.getInteger().sizeInBytes())));
            addTACInstruction(new IndexedValueInstruction(newVariable, newVariable, realIndex));
        }
        expression.toTac();
        addTACInstruction(new ProductInstruction(realIndex, lastIndex, new TACLiteral(Type.getArray(primitiveType, (declarationNumDimensions - indexesList.size() - 1)).sizeInBytes())));
        addTACInstruction(new AddInstruction(realIndex, realIndex, new TACLiteral(Type.getInteger().sizeInBytes())));
        addTACInstruction(new IndexAssignmentInstruction(newVariable, realIndex, expression.getTacVariable()));
    }
}
