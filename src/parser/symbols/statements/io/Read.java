package parser.symbols.statements.io;

import java.io.PrintWriter;
import parser.symbols.statements.Statement;

public final class Read extends Statement {
    
    private final String identifier;
    
    public Read(String identifier) {
        this.identifier = identifier;
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
