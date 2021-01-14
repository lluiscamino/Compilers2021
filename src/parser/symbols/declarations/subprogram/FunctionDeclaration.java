package parser.symbols.declarations.subprogram;

import dot.DotNode;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Return;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class FunctionDeclaration extends SubprogramDeclaration {
    private final Type type;
    private final Return returnStatement;
    
    public FunctionDeclaration(String identifier, Type type, SymbolList<Argument> arguments, SymbolList<Statement> statements, Return returnStatement) {
        super(identifier, arguments, statements);
        this.type = type;
        this.returnStatement = returnStatement;
    }
    
    public Type getReturnType() {
        return returnStatement.getExpressionType();
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
        returnStatement.validate(symbolTable);
        symbolTable.exitBlock();
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "FUNCTION", "", "filled", "#0077ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(type, "type");
        dotNode.addEdgeIfNotNull(arguments, "args");
        dotNode.addEdgeIfNotNull(statements, "stmts");
        dotNode.addEdge(returnStatement, "return");
    }
    
}
