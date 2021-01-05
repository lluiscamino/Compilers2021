package parser.symbols.expressions;

import java.io.PrintWriter;
import java.util.List;
import parser.symbols.ParserSymbol;

public final class ExpressionList extends ParserSymbol {
    
    private static final String STRING_IDENTIFIER = "EXPR_LIST";
    
    private final Expression expression;
    private final ExpressionList expressionsList;
    
    public ExpressionList(Expression expression, ExpressionList expressionsList) {
        super(STRING_IDENTIFIER);
        this.expression = expression;
        this.expressionsList = expressionsList;
    }
    
    public ExpressionList() {
        super(STRING_IDENTIFIER);
        this.expression = null;
        this.expressionsList = null;
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
