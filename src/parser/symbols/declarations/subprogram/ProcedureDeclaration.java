package parser.symbols.declarations.subprogram;

import analyzers.SemanticAnalyzer;
import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.Argument;
import parser.symbols.SymbolList;
import parser.symbols.statements.Statement;
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
        return lineNum + ": procedure " + identifier + " (" + numArguments() + " args)";
    }
    
}
