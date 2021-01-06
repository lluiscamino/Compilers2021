package parser.symbols.expressions.literals;

import dot.DotNode;
import java.io.PrintWriter;
import java.util.List;

public final class ArrayLiteral extends Literal {
    
    public ArrayLiteral(LiteralList literalsList) {
        super(literalsList);
    }
    
    @Override
    public List<Literal> getValue() {
        return (List<Literal>) literalValue;
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
        dotNode.addEdgeIfNotNull(literalsList, "literals");
    }
}
