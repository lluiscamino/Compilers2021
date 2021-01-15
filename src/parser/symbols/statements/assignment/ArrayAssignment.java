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
        System.out.println(indexes.numIndexes());
        CVADeclaration declaration = symbolTable.getCVA(identifier);
        if (declaration != null) {
            if (declaration.getMode().isVariable()) {
                if (declaration instanceof ArrayDeclaration) {
                    Type expectedType = getExpectedType((ArrayDeclaration) declaration);
                    if (expectedType == null) {
                        System.err.println("El array " + identifier + " no tiene tantas dimensiones");
                    } else if (!(expression.getType().equals(expectedType))) {
                        System.err.println("No se puede asignar un valor de tipo " + expression.getType() + " a una variable de tipo " + expectedType);
                    }
                } else {
                    System.err.println(identifier + " no es un ARRAY");
                }
            } else {
                System.err.println(identifier + " es constante, no se puede variar su valor");
            }
        } else {
            System.err.println("No existe ninguna variable llamada " + identifier);
        }
        indexes.validate(symbolTable);
        expression.validate(symbolTable);
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
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARR_ASSGN", "", "filled", "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(indexes, "indexes");
        dotNode.addEdge(expression, "expr");
    }
}
