package parser.symbols.statements.loop;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.declarations.Declaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.statements.assignment.Assignment;
import main.Compiler;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public class ForLoop extends Loop {

    private final SymbolList<Declaration> declarations;
    private final SymbolList<Assignment> assignments;
    
    public ForLoop(SymbolList<Declaration> declarations, Expression condition, SymbolList<Assignment> assignments, SymbolList<Statement> statements) {
        super(condition, statements);
        this.declarations = declarations;
        this.assignments = assignments;
    }
    

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        //mirar que el tipo sea booleano
        Type condType = condition.getType();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición del bucle debe ser de tipo " + Type.getBoolean() + ", no de tipo " + condType);
        }
        //crear nuevo bloque y validar los atributos
        symbolTable.enterBlock();
        if (declarations != null) {
            declarations.validate();
        }
        condition.validate();
        if (assignments != null) {
            assignments.validate();
        }
        if (statements != null) {
            statements.validate();
        }
        symbolTable.exitBlock();
        
    }

    @Override
    public void toDot() {
            DotNode dotNode = new DotNode("FOR", "box", "filled", "#5280d6");
            dotNode.addEdgeIfNotNull(declarations, "decls");
            dotNode.addEdge(condition, "cond");
            dotNode.addEdgeIfNotNull(assignments, "assigns");
            dotNode.addEdgeIfNotNull(statements, "stmts");
    }
    
}
