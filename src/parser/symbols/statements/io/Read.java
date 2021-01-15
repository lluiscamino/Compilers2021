package parser.symbols.statements.io;

import dot.DotNode;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public final class Read extends Statement {
    
    private final String identifier;
    
    public Read(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        CVADeclaration declaration = symbolTable.getCVA(identifier);
        if (declaration != null) {
            if (declaration.getMode().isVariable()) {
                if (!declaration.getType().isString()) {
                    System.err.println("No se puede asignar el resultado de una operación read() a una variable de tipo " + declaration.getType() + " (la variable debe ser de tipo STRING)");
                }
            } else {
                System.err.println(identifier + " es constante, no se puede variar su valor");
            }
        } else {
            System.err.println("No existe ninguna variable llamada " + identifier);
        }
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "READ", "", "filled", "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
    }
    
}
