package parser.symbols.expressions.literals;

import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;


public abstract class Literal extends Expression {
    protected final Object literalValue;
    
    public Literal(Object value, Type type, Location location) {
        super(type, Mode.CONST, location);
        this.literalValue = value;
    }
    
    public abstract Object getValue();
    
    @Override
    public void validate() {
    }
}
