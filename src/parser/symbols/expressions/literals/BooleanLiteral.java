package parser.symbols.expressions.literals;

import dot.DotNode;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public class BooleanLiteral extends Literal {
    
    public BooleanLiteral(boolean value) {
        super(value, Type.getBoolean());
    }
    
    @Override
    public Boolean getValue() {
        return (boolean) literalValue;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "BOOL_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, String.valueOf(getValue()), "plaintext", "", "");
        }, "value");
    }
    
}
