package parser.symbols.statements.assignment;

import dot.DotNode;
import parser.symbols.ArrayDimensions;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class ArrayAssignment extends Assignment {

    private final ArrayIndexes indexes;

    public ArrayAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, expression);
        this.indexes = indexes;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        try {
            CVADeclaration declaration = symbolTable.getCVA(identifier);
            if (declaration == null) {
                addSemanticError("No existe ninguna variable llamada " + identifier);
                return;
            }
            if (declaration.getMode().isConstant()) {
                addSemanticError(identifier + " es constante, no se puede variar su valor");
                return;
            }
            if (!(declaration instanceof ArrayDeclaration)) {
                addSemanticError(identifier + " no es un ARRAY");
                return;
            }
            Type expectedType = getExpectedType((ArrayDeclaration) declaration);
            if (expectedType == null) {
                addSemanticError("El array " + identifier + " no tiene tantas dimensiones");
            } else if (!(expression.getType().equals(expectedType))) {
                addSemanticError("No se puede asignar un valor de tipo " + expression.getType() + " a una variable de tipo " + expectedType);
            }
        } finally {
            indexes.validate(symbolTable);
            expression.validate(symbolTable);
        }
    }
    
    private Type getExpectedType(ArrayDeclaration declaration) {
        int numIndexes = indexes.numIndexes();
        int numArrayDimensions = declaration.getDimensions().size();
        if (numIndexes > numArrayDimensions) {
            return null;
        }
        int numDimensions = numArrayDimensions - numIndexes;
        ArrayDimensions dimensions = null;
        PrimitiveType primType = declaration.getType().getPrimitiveType();
        if (numDimensions > 0) {
            dimensions = new ArrayDimensions();
            for (int i = 0; i < numDimensions - 1; i++) dimensions.addNewDimension();
        }
        return new Type(primType, dimensions);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_ASSGN", "", "filled", "#00a2ff");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(indexes, "indexes");
        dotNode.addEdge(expression, "expr");
    }
}
