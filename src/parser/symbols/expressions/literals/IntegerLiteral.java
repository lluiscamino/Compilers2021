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
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("INT_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
             new DotNode(Integer.toString(getValue()), "plaintext", "", "");
        }, "value");
    }
    
}
