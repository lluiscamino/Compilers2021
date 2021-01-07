package parser.symbols.expressions.literals;

import dot.DotNode;
import java.util.Stack;
import parser.symbols.SymbolList;
import parser.symbols.types.Type;

public final class ArrayLiteral extends Literal {
    
    public ArrayLiteral(SymbolList<Literal> literalsList) {
        super(literalsList, Type.getArray(null, getNumDimensions(literalsList)));
        getNumDimensions(literalsList);
    }
    
    private ArrayLiteral() {
        super(null, null);
    }
    
    private static int getNumDimensions(SymbolList<Literal> literalsList) {
        Stack<Object> stack = new Stack<>();
        Stack<ArrayLiteral> dimensionsQueue = new Stack<>();
        stack.add(literalsList);
        dimensionsQueue.add(new ArrayLiteral());
        int maxDimension = 1;
        while (!stack.empty()) {
            Object element = stack.pop();
            if (element == null) {
                dimensionsQueue.pop();
                continue;
            }
            if (element instanceof SymbolList) {
                SymbolList<Literal> symbolList = (SymbolList<Literal>) element;
                stack.add(symbolList.next());
                stack.add(symbolList.getElement());
            } else if (element instanceof ArrayLiteral) {
                ArrayLiteral arrayLit = (ArrayLiteral) element;
                dimensionsQueue.add(arrayLit);
                if (dimensionsQueue.size() > maxDimension) {
                    maxDimension = dimensionsQueue.size();
                }
                stack.add(arrayLit.getValue());
            }
        }
        return maxDimension;
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
        
        dotNode.addEdgeIfNotNull(getValue(), "literals");
    }
}
