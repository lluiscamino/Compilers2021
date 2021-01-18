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
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("BOOL_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
            new DotNode(String.valueOf(getValue()), "plaintext", "", "");
        }, "value");
    }
    
}
