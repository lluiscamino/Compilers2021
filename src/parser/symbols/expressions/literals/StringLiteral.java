package parser.symbols.expressions.literals;

import dot.DotNode;
import parser.symbols.types.Type;

public class StringLiteral extends Literal {
    
    public StringLiteral(String value) {
        super(value, Type.getString());
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
