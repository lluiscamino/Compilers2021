package parser.symbols.expressions;

import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;

public final class MockExpression extends Expression {
    
    public MockExpression(Location location) {
        super(Type.getUnknown(), Mode.UNKNOWN, location);
    }

    @Override
    public void validate() {
    }

    @Override
    public void toDot() {
    }

    @Override
    public void toTac() {
    }
}
