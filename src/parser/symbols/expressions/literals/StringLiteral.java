package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;

public class StringLiteral extends Literal {
    
    public StringLiteral(String value, Location location) {
        super(value, Type.getString(), location);
    }
    
    @Override
    public String getValue() {
        return (String) literalValue;
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("STR_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
            new DotNode(getValue(), "plaintext", "", "");
        }, "value");
    }
    
}
