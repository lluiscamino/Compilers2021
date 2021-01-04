package parser.symbols.declarations.subprogram;

import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.declarations.Declaration;
import parser.symbols.statements.Statement;

public abstract class SubprogramDeclaration extends Declaration {
    protected final String identifier;
    protected final SymbolList<Argument> arguments;
    protected final SymbolList<Statement> statements;

    public SubprogramDeclaration(String identifier, SymbolList<Argument> arguments, SymbolList<Statement> statements) {
        this.identifier = identifier;
        this.arguments = arguments == null ? new SymbolList<>() : arguments;
        this.statements = statements == null ? new SymbolList<>() : statements;
    }
}
