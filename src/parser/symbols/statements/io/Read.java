package parser.symbols.statements.io;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;

public final class Read extends Statement {
    
    private final String identifier;
    
    public Read(String identifier, Location location) {
        super(location);
        this.identifier = identifier;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        CVADeclaration declaration = symbolTable.getCVA(identifier);
        if (declaration == null) {
            addSemanticError("No existe ninguna variable llamada " + identifier);
        } else if (declaration.getMode().isConstant()) {
            addSemanticError(identifier + " es constante, no se puede variar su valor");
        } else if (!declaration.getType().isString()) {
            addSemanticError("No se puede asignar el resultado de una operación read() a una variable de tipo " + declaration.getType() + " (la variable debe ser de tipo " + Type.getString() + ")");
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("READ", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
    }
    
}
