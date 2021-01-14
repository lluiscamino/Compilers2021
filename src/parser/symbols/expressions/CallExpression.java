package parser.symbols.expressions;

import parser.symbols.Call;
import symboltable.SymbolTable;


public final class CallExpression extends Expression {
    private final Call call;
    
    public CallExpression(Call call) {
        super(call.getReturnType(), Mode.RESULT);
        this.call = call;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        call.toDot(buffer);
    }
    
}
