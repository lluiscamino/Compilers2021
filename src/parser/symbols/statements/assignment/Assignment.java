package parser.symbols.statements.assignment;

import dot.DotNode;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public class Assignment extends Statement {

    protected final String identifier;
    protected final Expression expression;

    public Assignment(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        CVADeclaration declaration = symbolTable.getCVA(identifier);
        if (declaration != null) {
            if (declaration.getMode().isVariable()) {
                if (!declaration.getType().equals(expression.getType())) {
                    System.err.println("No se puede asignar un valor de tipo " + expression.getType() + " a una variable de tipo " + declaration.getType());
                }
            } else {
                System.err.println(identifier + " es constante, no se puede variar su valor");
            }
        } else {
            System.err.println("No existe ninguna variable llamada " + identifier);
        }
        expression.validate(symbolTable);
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ASSGN", "", "filled", "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "expr");
    }

}
