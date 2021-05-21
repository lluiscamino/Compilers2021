package parser.symbols.statements;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Return extends Statement {
    private final Expression expression;
    
    public Return(Expression expression) {
        super(expression.xleft);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getExpressionType() {
        return expression.getType();
    }

    @Override
    public void validate() {
        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("RETURN", "", "filled", "#5280d6");
        dotNode.addEdge(expression);
    }

    @Override
    public void toTac() {
        expression.toTac();
    }
}
