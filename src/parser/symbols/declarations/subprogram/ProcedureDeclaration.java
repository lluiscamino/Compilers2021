package parser.symbols.declarations.subprogram;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Statement;

public class ProcedureDeclaration extends SubprogramDeclaration {
    
    public ProcedureDeclaration(String identifier, SymbolList<Argument> arguments, SymbolList<Statement> statements) {
        super(identifier, arguments, statements);
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        DotNode dotNode = new DotNode(this, "PROCEDURE " + identifier, "", "filled", "#00a2ff");
        dotNode.addEdge(arguments, "args");
        dotNode.addEdge(statements, "stmts");
        
        dotNode.print(out);
        
        arguments.toDot(out);
        statements.toDot(out);
        
    }
    
}
