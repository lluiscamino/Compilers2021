package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Negative extends Expression {

    private final Expression expression;

    public Negative(Expression expression) {
        super(Type.getInteger(), Mode.RESULT, expression.xleft);
        this.expression = expression;
    }

    @Override
    public void validate() {
        //mirar si la expresion es un entero
        if (!expression.getType().isInteger()) {
            addSemanticError("No se puede hacer una operación aritmética con un tipo que no sea entero");
        }

    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("NEG", "box", "filled", "#9077bf");

        dotNode.addEdgeIfNotNull(expression);
    }

}
