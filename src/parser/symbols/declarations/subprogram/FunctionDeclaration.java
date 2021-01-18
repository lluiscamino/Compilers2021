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
        return type;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        if (!symbolTable.put(this)) {
            addSemanticError("Variable " + identifier + " ya definida");
        }
        symbolTable.enterBlock();
        validateArguments(symbolTable);
        validateStatements(symbolTable);
        returnStatement.validate(symbolTable);
        validateReturnType();
        symbolTable.exitBlock();
    }
    
    private void validateReturnType() {
        Type returnType = returnStatement.getExpressionType();
        if (!type.equals(returnType)) {
            addSemanticError("La función " + identifier + " debería devolver un tipo " + type + " pero devuelve un valor de tipo " + returnType);
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("FUNCTION", "", "filled", "#0077ff");
        
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(type, "type");
        dotNode.addEdgeIfNotNull(arguments, "args");
        dotNode.addEdgeIfNotNull(statements, "stmts");
        dotNode.addEdge(returnStatement, "return");
    }
    
}
