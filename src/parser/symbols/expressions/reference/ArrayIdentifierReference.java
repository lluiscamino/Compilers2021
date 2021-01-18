package parser.symbols.expressions.reference;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.CVADeclaration;
import symboltable.SymbolTable;
import main.Compiler;
import parser.symbols.ArrayDimensions;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;

public final class ArrayIdentifierReference extends IdentifierReference {
    private final ArrayIndexes indexes;
    
    public ArrayIdentifierReference(String identifierName, ArrayIndexes indexes, Location location) {
        super(identifierName, location);
        this.indexes = indexes;
    }
    
    @Override
    public Type getType() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null || !(decl instanceof ArrayDeclaration)) {
            return Type.getUnknown();
        }
        ArrayDeclaration arrDecl = (ArrayDeclaration) symbolTable.getCVA(identifierName);
        int numIndexes = indexes.numIndexes();
        int numArrayDimensions = arrDecl.getDimensions().size();
        if (numIndexes > numArrayDimensions) {
            return Type.getUnknown();
        }
        int numDimensions = numArrayDimensions - numIndexes;
        PrimitiveType primType = arrDecl.getType().getPrimitiveType();
        return Type.getArray(primType, numDimensions);
    }
    
    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null) {
            addSemanticError("No existe ninguna variable llamada " + identifierName);
        }
        if (!(decl instanceof ArrayDeclaration)) {
            addSemanticError(identifierName + " no es un array");
        }
        ArrayDeclaration arrDecl = (ArrayDeclaration) symbolTable.getCVA(identifierName);
        int numIndexes = indexes.numIndexes();
        int numArrayDimensions = arrDecl.getDimensions().size();
        if (numIndexes > numArrayDimensions) {
            addSemanticError("El array " + identifierName + " no tiene tantas dimensiones");
        }
        
        indexes.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IDENT_ARR", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
            new DotNode(identifierName, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(indexes, "indexes");
    }
    
}
