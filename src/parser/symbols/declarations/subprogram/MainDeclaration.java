package parser.symbols.declarations.subprogram;

import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Statement;

public final class MainDeclaration extends ProcedureDeclaration {
    
    public MainDeclaration(SymbolList<Argument> arguments, SymbolList<Statement> statements, Location location) {
        super("main", arguments, statements, location);
    }
    
}
