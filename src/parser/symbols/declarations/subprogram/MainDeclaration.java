package parser.symbols.declarations.subprogram;

import java.util.List;
import parser.symbols.Argument;
import parser.symbols.statements.Statement;

public final class MainDeclaration extends ProcedureDeclaration {
    
    public MainDeclaration(List<Argument> arguments, List<Statement> statements) {
        super("main", arguments, statements);
    }
    
}
