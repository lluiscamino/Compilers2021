package parser.symbols.expressions.literals;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;


public abstract class Literal extends Expression {
    protected final Object literalValue;
    
    public Literal(Object value, Type type) {
        super(type, Mode.CONST);
        this.literalValue = value;
    }
    
    public abstract Object getValue();
}
