package parser.symbols.expressions.literals;

import dot.DotNode;
import parser.symbols.SymbolList;

public final class ArrayLiteral extends Literal {
    
    public ArrayLiteral(SymbolList<Literal> literalsList) {
        super(literalsList);
    }
    
    @Override
    public SymbolList<Literal> getValue() {
        return (SymbolList<Literal>) literalValue;
    }
    
    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "ARR_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, "Literal_List", "plaintext", "", "");
        }, "ident");
        //dotNode.addEdgeIfNotNull(value, "literals");
    }
}
