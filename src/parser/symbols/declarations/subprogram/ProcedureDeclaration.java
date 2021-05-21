package parser.symbols.declarations.subprogram;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import main.Compiler;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;
import tac.instructions.TACInstruction;
import tac.instructions.subprogram.returns.ProcedureReturnInstruction;

public class ProcedureDeclaration extends SubprogramDeclaration {
    
    public ProcedureDeclaration(String identifier, SymbolList<Argument> arguments, 
            SymbolList<Statement> statements, Location location) {
        super(identifier, arguments, statements, location);
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
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
    public String toString() {
        int lineNum = xleft != null ? xleft.getLine() : -1;
        return lineNum + ": procedure " + identifier + " (" + numArguments() + " args)";
    }

    @Override
    protected TACInstruction returnInstruction() {
        return new ProcedureReturnInstruction(tacSubprogram);
    }
}
