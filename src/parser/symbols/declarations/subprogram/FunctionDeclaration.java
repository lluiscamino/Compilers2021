package parser.symbols.declarations.subprogram;

import analyzers.SemanticAnalyzer;
import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Return;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;
import tac.generators.TACSubprogramGenerator;
import tac.generators.TACTagGenerator;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.subprogram.PreambleInstruction;
import tac.instructions.subprogram.ReturnInstruction;
import tac.references.TACSubprogram;
import tac.references.TACTag;
import tac.tables.SubprogramsTable;

public final class FunctionDeclaration extends SubprogramDeclaration {
    private final Type type;
    private final Return returnStatement;
    
    public FunctionDeclaration(String identifier, Type type, SymbolList<Argument> arguments, 
            SymbolList<Statement> statements, Return returnStatement, Location location) {
        super(identifier, arguments, statements, location);
        this.type = type;
        this.returnStatement = returnStatement;
    }
    
    public Type getReturnType() {
        return type;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        symbolTable.enterBlock();
        validateArguments(symbolTable);
        validateStatements(symbolTable);
        returnStatement.validate();
        validateReturnType();
        symbolTable.exitBlock();
    }
    
    private void validateReturnType() {
        Type returnType = returnStatement.getExpressionType();
        if (!type.isUnknown() && !returnType.isUnknown() && !type.equals(returnType)) {
            addSemanticError("La función " + identifier + " debería devolver un tipo " + type + " pero devuelve un valor de tipo " + returnType);
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("FUNCTION", "", "filled", "#005cc5");
        
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(type, "type");
        dotNode.addEdgeIfNotNull(arguments, "args");
        dotNode.addEdgeIfNotNull(statements, "stmts");
        dotNode.addEdge(returnStatement, "return");
    }

    @Override
    public void toTac() {
        SemanticAnalyzer semanticAnalyzer = Compiler.getCompiler().getSemanticAnalyzer();
        SymbolTable symbolTable = semanticAnalyzer.getSymbolTable();
        TACSubprogramGenerator subprogramGenerator = semanticAnalyzer.getTacSubprogramGenerator();
        TACTagGenerator tagGenerator = semanticAnalyzer.getTacTagGenerator();
        SubprogramsTable subprogramsTable = semanticAnalyzer.getSubprogramsTable();

        TACSubprogram subprogram = subprogramGenerator.generate();
        TACTag startTag = tagGenerator.generate();
        subprogramsTable.add(subprogram, startTag, numArguments());
        addTACInstruction(new SkipInstruction(startTag));
        addTACInstruction(new PreambleInstruction(subprogram));
        symbolTable.enterBlock();
        if (statements != null) {
            statements.toTac();
        }
        symbolTable.exitBlock();
        addTACInstruction(new ReturnInstruction(subprogram));
    }
    
    @Override
    public String toString() {
        int lineNum = xleft != null ? xleft.getLine() : -1;
        return lineNum + ": function " + identifier + " " + type + " (" + numArguments() + " args)";
    }
    
}
