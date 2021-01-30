package parser.symbols.statements.loop;

import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.declarations.Declaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;
import main.Compiler;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.types.Type;

public class ForeachLoop extends Loop {

    private final Declaration declaration;

    public ForeachLoop(Declaration declaration, Expression condition, SymbolList<Statement> statements) {
        super(condition, statements);
        this.declaration = declaration;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        //mirar que el objeto a iterar sea un array
        if (!this.condition.getType().isArray()) {
            this.addSemanticError(condition.getName() + " no es un tipo array.");
        }
        //mirar si la declaracion es un tipo cva
        if (!(declaration instanceof CVADeclaration)) {
            this.addSemanticError("Se debe declarar un tipo variable, no un subprograma.");
        }
        Type type = symbolTable.getCVA(declaration.getIdentifier()).getType();
            
        //mirar si el tipo de la declaracion corresponde con el tipo del array    
        if (!type.equals(condition.getType())) {
            this.addSemanticError("Se esperaba un array de tipo " + type.getName());
        }
        symbolTable.enterBlock();
        declaration.validate();
        condition.validate();
        if (statements != null) {
            statements.validate();
        }
        symbolTable.exitBlock();
        
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("FOREACH", "box", "filled", "#5280d6");
        dotNode.addEdgeIfNotNull(declaration, "decl");
        dotNode.addEdge(condition, "cond");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

}
