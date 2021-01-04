package parser.symbols.declarations.subprogram;

import java.io.PrintWriter;
import java.util.List;
import parser.symbols.Argument;
import parser.symbols.statements.Return;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;

public final class FunctionDeclaration extends SubprogramDeclaration {
    private final Type type;
    private final Return returnStatement;
    
    public FunctionDeclaration(String identifier, Type type, List<Argument> arguments, List<Statement> statements, Return returnStatement) {
        super(identifier, arguments, statements);
        this.type = type;
        this.returnStatement = returnStatement;
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
