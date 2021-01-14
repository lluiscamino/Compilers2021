package parser.symbols.declarations.subprogram;

import dot.DotNode;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public class ProcedureDeclaration extends SubprogramDeclaration {
    
    public ProcedureDeclaration(String identifier, SymbolList<Argument> arguments, SymbolList<Statement> statements) {
        super(identifier, arguments, statements);
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        symbolTable.enterBlock();
        symbolTable.put(this);
        if (arguments != null) {
            for (Argument argument : arguments.toArrayList()) {
                argument.validate(symbolTable);
            }
        }
        if (statements != null) {
            for (Statement statement : statements.toArrayList()) {
                statement.validate(symbolTable);
            }
        }
        symbolTable.exitBlock();
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "PROCEDURE", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(arguments, "args");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }
    
}
