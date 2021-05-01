package parser.symbols.statements.conditional;

import dot.DotNode;
import main.Compiler;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;
import tac.generators.TACTagGenerator;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfEqual;
import tac.references.TACTag;

public final class IfElse extends If {

    private final SymbolList<Statement> elseStatements;

    public IfElse(Expression condition, SymbolList<Statement> statements, SymbolList<Statement> elseStatements) {
        super(condition, statements);
        this.elseStatements = elseStatements;
    }

    @Override
    public void validate() {
        super.validate();
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        symbolTable.enterBlock();
        if (elseStatements != null) {
            elseStatements.validate();
        }
        symbolTable.exitBlock();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IF", "", "filled", "#5280d6");
        
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
        dotNode.addEdgeIfNotNull(elseStatements, "else-stmts");
    }

    @Override
    public void toTac() {
        TACTagGenerator tagGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacTagGenerator();
        condition.toTac();
        TACTag tag = tagGenerator.generate();
        addTACInstruction(new IfEqual(condition.getTacVariable(), 0, tag));
        if (statements != null) {
            statements.toTac();
        }
        TACTag endTag = tagGenerator.generate();
        addTACInstruction(new GotoInstruction(endTag));
        addTACInstruction(new SkipInstruction(tag));
        if (elseStatements != null) {
            elseStatements.toTac();
        }
        addTACInstruction(new SkipInstruction(endTag));
    }
}
