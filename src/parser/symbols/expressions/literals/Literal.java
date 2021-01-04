package parser.symbols.expressions.literals;

import parser.symbols.expressions.Expression;


public abstract class Literal extends Expression {
    private final Object literalValue;
    
    public Literal(Object value) {
        this.literalValue = value;
    }
}
