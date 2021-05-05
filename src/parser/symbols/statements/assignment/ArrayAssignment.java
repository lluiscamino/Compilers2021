package parser.symbols.statements.assignment;

import dot.DotNode;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public class ArrayAssignment extends Assignment {

    private final ArrayIndexes indexes;

    public ArrayAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, expression);
        this.indexes = indexes;
    }

    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
            CVADeclaration declaration = symbolTable.getCVA(identifier);
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
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(indexes, "indexes");
        dotNode.addEdge(expression, "expr");
    }

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        TACVariable variable = variablesTable.get(identifier).getTacVariable();
        indexes.toTac();
        expression.toTac();
        addTACInstruction(new IndexAssignmentInstruction(variable, indexes.getOffset(), expression.getTacVariable()));
    }
}
