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
        if (arguments != null) dotNode.addEdge(arguments, "args");
        if (statements != null) dotNode.addEdge(statements, "stmts");
        
        dotNode.print(out);
        
        if (arguments != null) arguments.toDot(out);
        if (statements != null) statements.toDot(out);
        
    }
    
}
