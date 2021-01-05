package parser.symbols.expressions.literals;

import parser.symbols.expressions.Expression;


public abstract class Literal extends Expression {
    protected final Object literalValue;
    
    public Literal(Object value) {
        this.literalValue = value;
    }
    
    public abstract Object getValue();
}
