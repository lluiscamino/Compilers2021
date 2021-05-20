package parser.symbols.statements.loop;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import main.Compiler;
import symboltable.SymbolTable;
import tac.generators.TACTagGenerator;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfEqual;
import tac.references.TACLiteral;
import tac.references.TACTag;

import static assembly.AssemblyCodeGenerationConstants.FALSE;

public final class WhileLoop extends Loop {

    public WhileLoop(Expression condition, SymbolList<Statement> statements) {
        super(condition, statements);
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        Type condType = condition.getType();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición del bucle debe ser de tipo " + Type.getBoolean() + ", no de tipo " + condType);
        }
        symbolTable.enterBlock();
        condition.validate();
        if (statements != null) {
            statements.validate();
        }
        symbolTable.exitBlock();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("WHILE", "box", "filled", "#5280d6");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

    @Override
    public void toTac() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        TACTagGenerator tagGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacTagGenerator();
        TACTag startTag = tagGenerator.generate();
        addTACInstruction(new SkipInstruction(startTag));
        symbolTable.enterBlock();
        condition.toTac();
        TACTag endTag = tagGenerator.generate();
        addTACInstruction(new IfEqual(condition.getTacVariable(), new TACLiteral(FALSE), endTag));
        if (statements != null) {
            statements.toTac();
        }
        symbolTable.exitBlock();
        addTACInstruction(new GotoInstruction(startTag));
        addTACInstruction(new SkipInstruction(endTag));
    }
}
