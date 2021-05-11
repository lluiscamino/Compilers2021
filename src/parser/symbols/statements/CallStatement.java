package parser.symbols.statements;

import main.Compiler;
import parser.symbols.Call;
import tac.instructions.subprogram.calls.ProcedureCallInstruction;
import tac.references.TACSubprogram;
import tac.tables.SubprogramsTable;

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
        SubprogramsTable subprogramsTable = Compiler.getCompiler().getSemanticAnalyzer().getSubprogramsTable();

        call.toTac();
        TACSubprogram subprogram = subprogramsTable.get(call.getSubProgramIdentifier()).getTacSubprogram();
        addTACInstruction(new ProcedureCallInstruction(subprogram));
    }
}
