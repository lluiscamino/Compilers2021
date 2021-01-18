package parser.symbols.expressions.literals;

import dot.DotNode;
import java.util.List;
import java.util.Stack;
import parser.symbols.SymbolList;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;

public final class ArrayLiteral extends Literal {
    
    public ArrayLiteral(SymbolList<Literal> literalsList) {
        super(literalsList, Type.getArray(getPrimitiveType(literalsList), getNumDimensions(literalsList)));
    }
    
    private ArrayLiteral() {
        super(null, null);
    }
    
    private static PrimitiveType getPrimitiveType(SymbolList<Literal> literalsList) {
        if (literalsList == null || literalsList.getElement() == null) {
            return PrimitiveType.UNKNOWN;
        }
        return literalsList.getElement().getType().getPrimitiveType();
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
        //pasar los elementos a una lista
        if (getValue() == null || getValue().size() <= 1) return;
        List<Literal> elements = getValue().toArrayList();
        //mirar si algun elemento es de otro tipo
        Type firstElementType = elements.get(0).getType();
        for (Literal l : elements) {
            if (!(l.getType().equals(firstElementType))) {
                addSemanticError("Los elementos de un array tienen que ser del mismo tipo. Se encontró un elemento de tipo " + l.getType() + " en un array de " + firstElementType);
                return;
            }
            if (l.getType().isArray()) { // Si el elemento es también un array, validarlo también
                l.validate();
            }
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_LIT", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(getValue(), "literals");
    }
}
