package parser.symbols.expressions.binary;

import java.io.PrintWriter;
import parser.RelationalOperatorType;
import parser.symbols.expressions.Expression;

public final class Relational extends Expression {
    private final Expression leftExpression, rightExpression;
    private final RelationalOperatorType operator;

    public Relational(
            Expression leftExpression, RelationalOperatorType operator, Expression rightExpression
    )
    {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
