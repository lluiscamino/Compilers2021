package parser.symbols.expressions;

import parser.symbols.Call;
import parser.symbols.types.Type;

public final class CallExpression extends Expression {
    private final Call call;
    
    public CallExpression(Call call) {
        super(Type.getUnknown(), Mode.RESULT, call.xleft);
        this.call = call;
    }
    
    @Override
    public Type getType() {
        return call.getReturnType();
    }

    @Override
    public void validate() {
        call.validate();
    }

    @Override
    public void toDot() {
        call.toDot();
    }
    
}
