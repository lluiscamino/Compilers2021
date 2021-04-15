package parser.symbols.expressions;

import dot.DotNode;
import parser.symbols.types.Type;

public final class Length extends Expression {
    private final Expression expression;
    
    public Length(Expression expression) {
        super(Type.getInteger(), Mode.RESULT, expression.xleft);
        this.expression = expression;
    }

    @Override
    public void validate() {
        Type type = expression.getType();
        if (!type.isUnknown() && !type.isArray() && !type.isString()) {
            addSemanticError("No se puede aplicar LENGTH a un valor de tipo " + type);
        }
        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("LENGTH", "box", "filled", "#9077bf");
        
        dotNode.addEdge(expression, "expr");
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
