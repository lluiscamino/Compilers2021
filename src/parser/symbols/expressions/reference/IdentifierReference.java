package parser.symbols.expressions.reference;

import dot.DotNode;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;

public class IdentifierReference extends Expression {

    protected final String identifierName;

    public IdentifierReference(String identifierName) {
        super(Type.getUnknown(), Mode.UNKNOWN);
        this.identifierName = identifierName;
    }
    
    @Override
    public Type getType() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        return decl != null ? decl.getType(): Type.getUnknown();
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        //mirar la tabla de simbolos
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null) {
            addSemanticError("No existe ninguna variable llamada " + identifierName);
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IDENT", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
            new DotNode(identifierName, "plaintext", "", "");
        }, "ident");
    }

}
