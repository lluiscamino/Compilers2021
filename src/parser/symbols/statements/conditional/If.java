package parser.symbols.statements.conditional;

import dot.DotNode;
import main.Compiler;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.generators.TACTagGenerator;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfEqual;
import tac.references.TACLiteral;
import tac.references.TACTag;

import static assembly.x86.AssemblyCodeGenerationConstants.FALSE;

public class If extends Statement {
    protected final Expression condition;
    protected final SymbolList<Statement> statements;

    public If(Expression condition, SymbolList<Statement> statements) {
        super(condition.xleft);
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        Type condType = condition.getType();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición del bucle debe ser de tipo " + Type.getBoolean());
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
        DotNode dotNode = new DotNode("IF", "", "filled", "#5280d6");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

    @Override
    public void toTac() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        TACTagGenerator tagGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacTagGenerator();
        symbolTable.enterBlock();
        condition.toTac();
        TACTag tag = tagGenerator.generate();
        addTACInstruction(new IfEqual(condition.getTacVariable(), new TACLiteral(FALSE), tag));
        if (statements != null) {
            statements.toTac();
        }
        symbolTable.exitBlock();
        addTACInstruction(new SkipInstruction(tag));
    }
}
