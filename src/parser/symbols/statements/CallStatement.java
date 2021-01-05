package parser.symbols.statements;

import java.io.PrintWriter;
import parser.symbols.Call;

public final class CallStatement extends Statement {
    private final Call call;
    
    public CallStatement(Call call) {
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
