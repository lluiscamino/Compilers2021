package parser.symbols.declarations.subprogram;

import java.util.ArrayList;
import java.util.List;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.declarations.Declaration;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public abstract class SubprogramDeclaration extends Declaration {
    protected final SymbolList<Argument> arguments;
    protected final SymbolList<Statement> statements;

    public SubprogramDeclaration(String identifier, SymbolList<Argument> arguments, SymbolList<Statement> statements) {
        super(identifier);
        this.arguments = arguments;
        this.statements = statements;
    }
    
    protected final void validateArguments(SymbolTable symbolTable) {
        if (arguments != null) {
            arguments.validate(symbolTable);
        }
    }
    
    protected final void validateStatements(SymbolTable symbolTable) {
        if (statements != null) {
            statements.validate(symbolTable);
        }
    }
    
    public final List<Argument> toArrayListArguments() {
        if (arguments == null) return new ArrayList<>();
        return arguments.toArrayList();
    }
}
