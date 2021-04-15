package parser.symbols.declarations.subprogram;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;
import main.Compiler;

public class ProcedureDeclaration extends SubprogramDeclaration {
    
    public ProcedureDeclaration(String identifier, SymbolList<Argument> arguments, 
            SymbolList<Statement> statements, Location location) {
        super(identifier, arguments, statements, location);
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        if (!symbolTable.isInInitialScope() && !symbolTable.put(this)) {
            addSemanticError("Procedimiento " + identifier + " ya definido");
        }
        symbolTable.enterBlock();
        validateArguments(symbolTable);
        validateStatements(symbolTable);
        symbolTable.exitBlock();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("PROCEDURE", "", "filled", "#005cc5");
        
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(arguments, "args");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        int lineNum = xleft != null ? xleft.getLine() : -1;
        int numArgs = arguments != null ? arguments.size() : 0;
        return lineNum + ": procedure " + identifier + " (" + numArgs + " args)";
    }
    
}
