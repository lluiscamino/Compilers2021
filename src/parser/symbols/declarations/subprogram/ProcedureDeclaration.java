package parser.symbols.declarations.subprogram;

import java.io.PrintWriter;
import java.util.List;
import parser.symbols.Argument;
import parser.symbols.statements.Statement;

public class ProcedureDeclaration extends SubprogramDeclaration {
    
    public ProcedureDeclaration(String identifier, List<Argument> arguments, List<Statement> statements) {
        super(identifier, arguments, statements);
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
