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
        Type exprType = expression.getType();
        if (!exprType.isUnknown() && !exprType.isInteger()) {
            addSemanticError("No se puede hacer una operación aritmética con un tipo que no sea " + Type.getInteger());
        }
        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("NEG", "box", "filled", "#9077bf");

        dotNode.addEdgeIfNotNull(expression);
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
