package parser.symbols.declarations.subprogram;

import java.util.List;
import parser.symbols.Argument;
import parser.symbols.declarations.Declaration;
import parser.symbols.statements.Statement;

public abstract class SubprogramDeclaration extends Declaration {
    private final String identifier;
    private final List<Argument> arguments;
    private final List<Statement> statements;

    public SubprogramDeclaration(String identifier, List<Argument> arguments, List<Statement> statements) {
        this.identifier = identifier;
        this.arguments = arguments;
        this.statements = statements;
    }
}
