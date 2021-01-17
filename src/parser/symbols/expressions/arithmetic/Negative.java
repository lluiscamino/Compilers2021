package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class Negative extends Expression {

    private final Expression expression;

    public Negative(Expression expression) {
        super(Type.getInteger(), Mode.RESULT);
        this.expression = expression;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        //mirar si la expresion es un entero
        if (!expression.getType().isInteger()) {
            addSemanticError("No se puede hacer una operación aritmética con un tipo que no sea entero");
        }

        expression.validate(symbolTable);
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "NEG", "", "filled", "#00a2ff");

        dotNode.addEdgeIfNotNull(expression);
    }

}
