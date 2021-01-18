package parser.symbols.expressions.reference;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.CVADeclaration;
import symboltable.SymbolTable;
import main.Compiler;

public final class ArrayIdentifierReference extends IdentifierReference {
    private final ArrayIndexes indexes;
    
    public ArrayIdentifierReference(String identifierName, ArrayIndexes indexes, Location location) {
        super(identifierName, location);
        this.indexes = indexes;
    }
    
    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null) {
            addSemanticError("No existe ninguna variable llamada " + identifierName);
        }
        if (!decl.getType().isArray()) {
            addSemanticError("El tipo no es un array.");
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
