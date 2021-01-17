package parser.symbols.expressions.arithmetic;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public abstract class ArithmeticOperation extends Expression {
    protected final Expression leftExpression, rightExpression;
    
    public ArithmeticOperation(Expression leftExpression, Expression rightExpression) {
        super(Type.getInteger(), Mode.RESULT);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    
    @Override
    public final void validate(SymbolTable symbolTable) {
        //mirar si las dos expresiones son enteros
        if (!(leftExpression.getType().isInteger() && rightExpression.getType().isInteger())) {
            addSemanticError("No se puede hacer una operación aritmética con un tipo que no sea " + Type.getInteger());
        }

        leftExpression.validate(symbolTable);
        rightExpression.validate(symbolTable);
    }
}
