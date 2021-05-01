package parser.symbols.declarations.subprogram;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.declarations.Declaration;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public abstract class SubprogramDeclaration extends Declaration {
    protected final SymbolList<Argument> arguments;
    protected final SymbolList<Statement> statements;

    public SubprogramDeclaration(String identifier, SymbolList<Argument> arguments, 
            SymbolList<Statement> statements, Location location) {
        super(identifier, location);
        this.arguments = arguments;
        this.statements = statements;
    }
    
    protected final void validateArguments(SymbolTable symbolTable) {
        if (arguments != null) {
            arguments.validate();
        }
    }
    
    protected final void validateStatements(SymbolTable symbolTable) {
        if (statements != null) {
            statements.validate();
        }
    }

    protected final int numArguments() {
        return arguments != null ? arguments.size() : 0;
    }
    
    public final List<Argument> toArrayListArguments() {
        if (arguments == null) return new ArrayList<>();
        return arguments.toArrayList();
    }
}
