package parser.symbols.expressions.io;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;
import parser.symbols.expressions.Expression;

public final class Read extends Expression {
    
    public Read(Location location) {
        super(Type.getString(), Mode.CONST, location);
    }

    @Override
    public void validate() {
        
    }

    @Override
    public void toDot() {
        new DotNode("READ", "box", "filled", "#8b7888");
    }
    
}
