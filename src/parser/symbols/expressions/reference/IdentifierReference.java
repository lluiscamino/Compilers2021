package parser.symbols.expressions.reference;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public class IdentifierReference extends Expression {

    protected final String identifierName;

    public IdentifierReference(String identifierName) {
        this.identifierName = identifierName;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "IDENT", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifierName, "plaintext", "", "");
        }, "ident");
    }

}
