package parser.symbols.expressions;

import parser.symbols.Call;
import parser.symbols.types.Type;
import symboltable.SymbolTable;


public final class CallExpression extends Expression {
    private final Call call;
    
    public CallExpression(Call call) {
        super(Type.getUnknown(), Mode.RESULT);
        this.call = call;
    }
    
    @Override
    public Type getType() {
        return call.getReturnType();
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        call.validate(symbolTable);
    }

    @Override
    public void toDot() {
        call.toDot();
    }
    
}
