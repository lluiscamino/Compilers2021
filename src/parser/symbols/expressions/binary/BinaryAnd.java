package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;

public final class BinaryAnd extends BinaryOperation {
    
    public BinaryAnd(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        //mirar si las dos expresiones son booleanas
        if (!(leftExpression.getType().isBoolean() && rightExpression.getType().isBoolean())) {
            System.err.println("No se puede hacer una operación lógica con un tipo que no sea booleano");
        }

        leftExpression.validate(symbolTable);
        rightExpression.validate(symbolTable);
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "AND", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
