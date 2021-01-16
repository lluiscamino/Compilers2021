package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;

public final class ArithmeticMultiply extends ArithmeticOperation {
    
    public ArithmeticMultiply(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        //mirar si las dos expresiones son enteros
        if (!(leftExpression.getType().isInteger() && rightExpression.getType().isInteger())) {
            System.err.println("No se puede hacer una operación aritmética con un tipo que no sea entero");
        }

        leftExpression.validate(symbolTable);
        rightExpression.validate(symbolTable);
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "MUL", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
