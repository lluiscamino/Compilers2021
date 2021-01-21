package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;

public final class IntegerLiteral extends Literal {
    
    public IntegerLiteral(int value, Location location) {
        super(value, Type.getInteger(), location);
    }
    
    @Override
    public Integer getValue() {
        return (int) literalValue;
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("INT_LIT", "box", "filled", "#f2ad46");
        
        dotNode.addEdge(() -> {
             new DotNode(Integer.toString(getValue()), "plaintext", "", "");
        }, "value");
    }
    
}
