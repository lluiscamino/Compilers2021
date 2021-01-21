package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;

public final class Not extends Expression {
    private final Expression expression;
    
    public Not(Expression expression) {
        super(Type.getBoolean(), Mode.RESULT, expression.xleft);
        this.expression = expression;
    }

    @Override
    public void validate() {
        //mirar si la expresion es booleana
        if (!expression.getType().isBoolean()) {
            addSemanticError("No se puede hacer una operación lógica con un tipo que no sea " + Type.getBoolean());
        }

        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("NOT_EXPR", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(expression, "expr");
    }
    
}
