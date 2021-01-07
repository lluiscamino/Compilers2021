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
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "STR_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, getValue(), "plaintext", "", "");
        }, "value");
    }
    
}
