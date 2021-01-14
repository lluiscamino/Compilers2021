package parser.symbols.expressions.literals;

import dot.DotNode;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class IntegerLiteral extends Literal {
    
    public IntegerLiteral(int value) {
        super(value, Type.getInteger());
    }
    
    @Override
    public Integer getValue() {
        return (int) literalValue;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "INT_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, Integer.toString(getValue()), "plaintext", "", "");
        }, "value");
    }
    
}
