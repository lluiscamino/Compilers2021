package parser.symbols.expressions.reference;

import java.io.PrintWriter;
import parser.symbols.expressions.Expression;

public class IdentifierReference extends Expression {

    private final String identifierName;

    public IdentifierReference(String identifierName) {
        this.identifierName = identifierName;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
