package parser.symbols.statements;

import parser.symbols.Call;

public final class CallStatement extends Statement {
    private final Call call;
    
    public CallStatement(Call call) {
        super(call.xleft);
        this.call = call;
    }

    @Override
    public void validate() {
        call.validate();
    }

    @Override
    public void toDot() {
        call.toDot();
    }

    @Override
    public void toTac() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
