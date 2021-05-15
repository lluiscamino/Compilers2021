package parser.symbols.expressions;

import main.Compiler;
import parser.symbols.Call;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.subprogram.calls.FunctionCallInstruction;
import tac.references.TACSubprogram;
import tac.tables.SubprogramsTable;

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
        if (call.getReturnType().isUnknown()) {
            addSemanticError(call.getSubProgramIdentifier() + " no tiene un valor de retorno");
        }
    }

    @Override
    public void toDot() {
        call.toDot();
    }

    @Override
    public void toTac() {
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        SubprogramsTable subprogramsTable = Compiler.getCompiler().getSemanticAnalyzer().getSubprogramsTable();

        tacVariable = variableGenerator.generate(call.getReturnType());
        call.toTac();
        TACSubprogram subprogram = subprogramsTable.get(call.getSubProgramIdentifier()).getTacSubprogram();
        addTACInstruction(new FunctionCallInstruction(tacVariable, subprogram));
    }
}
