package parser.symbols.declarations.subprogram;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Return;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;

public final class FunctionDeclaration extends SubprogramDeclaration {
    private final Type type;
    private final Return returnStatement;
    
    public FunctionDeclaration(String identifier, Type type, SymbolList<Argument> arguments, SymbolList<Statement> statements, Return returnStatement) {
        super(identifier, arguments, statements);
        this.type = type;
        this.returnStatement = returnStatement;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        DotNode dotNode = new DotNode(this, "FUNCTION " + identifier, "", "filled", "#0077ff");
        dotNode.addEdge(type, "type");
        if (arguments != null) dotNode.addEdge(arguments, "args");
        if (statements != null) dotNode.addEdge(statements, "stmts");
        dotNode.addEdge(returnStatement, "return");
        
        dotNode.print(out);
        
        type.toDot(out);
        if (arguments != null) arguments.toDot(out);
        if (statements != null) statements.toDot(out);
        returnStatement.toDot(out);
    }
    
}
