package parser.symbols.expressions.reference;

import dot.DotNode;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;

public class IdentifierReference extends Expression {

    protected final String identifierName;

    public IdentifierReference(String identifierName) {
        super(null, null);
        this.identifierName = identifierName;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        //mirar la tabla de simbolos
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null) {
            addSemanticError("No existe ninguna variable llamada " + identifierName);
        }
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "IDENT", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifierName, "plaintext", "", "");
        }, "ident");
    }

}
