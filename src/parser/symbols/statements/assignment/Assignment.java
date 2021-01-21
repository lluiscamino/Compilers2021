package parser.symbols.statements.assignment;

import dot.DotNode;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;
import main.Compiler;

public class Assignment extends Statement {

    protected final String identifier;
    protected final Expression expression;

    public Assignment(String identifier, Expression expression) {
        super(expression.xleft);
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
            CVADeclaration declaration = symbolTable.getCVA(identifier);
            if (declaration == null) {
                addSemanticError("No existe ninguna variable llamada " + identifier);
                return;
            }
            if (declaration.getMode().isConstant()) {
                addSemanticError(identifier + " es constante, no se puede variar su valor");
                return;
            }
            if (!declaration.getType().equals(expression.getType())) {
                addSemanticError("No se puede asignar un valor de tipo " + expression.getType() + " a una variable de tipo " + declaration.getType());
            }
        } finally {
            expression.validate();
        }

    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "expr");
    }

}
