package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.RelationalOperatorType;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class Relational extends Expression {
    private final Expression leftExpression, rightExpression;
    private final RelationalOperatorType operator;

    public Relational(Expression leftExpression, 
            RelationalOperatorType operator, Expression rightExpression) {
        super(Type.getBoolean(), Mode.RESULT);
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        //mirar si las dos expresiones son del mismo tipo
        if (!(leftExpression.getType().equals(rightExpression.getType()))) {
            addSemanticError("No se puede hacer una operación lógica con un tipo que no sea booleano");
        }

        leftExpression.validate(symbolTable);
        rightExpression.validate(symbolTable);
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "RELATIONAL", "", "filled", "#00a2ff");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression);
    }
}
