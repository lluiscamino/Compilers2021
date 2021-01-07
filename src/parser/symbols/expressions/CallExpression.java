package parser.symbols.expressions;

import parser.symbols.Call;


public final class CallExpression extends Expression {
    private final Call call;
    
    public CallExpression(Call call) {
        this.call = call;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        call.toDot(buffer);
    }
    
}
