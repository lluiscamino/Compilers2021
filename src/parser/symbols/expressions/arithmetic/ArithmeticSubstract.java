package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;

public final class ArithmeticSubstract extends ArithmeticOperation {
    
    public ArithmeticSubstract(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("SUB", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
