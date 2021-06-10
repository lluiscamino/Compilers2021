package assembly;

import tac.instructions.arithmetic.*;
import tac.instructions.array.NewDynamicArrayInstruction;
import tac.instructions.array.NewStaticArrayInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.instructions.bifurcation.ifs.specialtypes.IfDiffString;
import tac.instructions.bifurcation.ifs.specialtypes.IfEqualString;
import tac.instructions.binary.AndInstruction;
import tac.instructions.binary.NotInstruction;
import tac.instructions.binary.OrInstruction;
import tac.instructions.indexation.indexassignment.IndexAssignmentInstruction;
import tac.instructions.indexation.indexassignment.IndexAssignmentToZeroInstruction;
import tac.instructions.indexation.indexedvalue.IndexedValueInstruction;
import tac.instructions.indexation.indexedvalue.ZeroIndexedValueInstruction;
import tac.instructions.io.ReadInstruction;
import tac.instructions.io.print.PrintArrayInstruction;
import tac.instructions.io.print.PrintBooleanInstruction;
import tac.instructions.io.print.PrintIntInstruction;
import tac.instructions.io.print.PrintStringInstruction;
import tac.instructions.length.StringLengthInstruction;
import tac.instructions.special.InitProgramInstruction;
import tac.instructions.subprogram.ParameterInstruction;
import tac.instructions.subprogram.PreambleInstruction;
import tac.instructions.subprogram.calls.FunctionCallInstruction;
import tac.instructions.subprogram.calls.ProcedureCallInstruction;
import tac.instructions.subprogram.returns.FunctionReturnInstruction;
import tac.instructions.subprogram.returns.ProcedureReturnInstruction;

public interface AssemblyCodeGenerator {
    String preamble();

    String epilogue();

    String generate(InitProgramInstruction tacInstruction);

    String generate(AddInstruction tacInstruction);

    String generate(CopyInstruction tacInstruction);

    String generate(DivideInstruction tacInstruction);

    String generate(ModuloInstruction tacInstruction);

    String generate(NegativeInstruction tacInstruction);

    String generate(ProductInstruction tacInstruction);

    String generate(SubtractInstruction tacInstruction);

    String generate(IfDiff tacInstruction);

    String generate(IfEqual tacInstruction);

    String generate(IfGEQ tacInstruction);

    String generate(IfGreater tacInstruction);

    String generate(IfLEQ tacInstruction);

    String generate(IfLess tacInstruction);

    String generate(IfEqualString tacInstruction);

    String generate(IfDiffString tacInstruction);

    String generate(GotoInstruction tacInstruction);

    String generate(SkipInstruction tacInstruction);

    String generate(AndInstruction tacInstruction);

    String generate(NotInstruction tacInstruction);

    String generate(OrInstruction tacInstruction);

    String generate(IndexAssignmentInstruction tacInstruction);

    String generate(IndexAssignmentToZeroInstruction tacInstruction);

    String generate(IndexedValueInstruction tacInstruction);

    String generate(ZeroIndexedValueInstruction tacInstruction);

    String generate(ProcedureCallInstruction tacInstruction);

    String generate(FunctionCallInstruction tacInstruction);

    String generate(PreambleInstruction tacInstruction);

    String generate(ProcedureReturnInstruction tacInstruction);

    String generate(FunctionReturnInstruction tacInstruction);

    String generate(ParameterInstruction tacInstruction);

    String generate(ReadInstruction tacInstruction);

    String generate(PrintIntInstruction tacInstruction);

    String generate(PrintBooleanInstruction tacInstruction);

    String generate(PrintStringInstruction tacInstruction);

    String generate(PrintArrayInstruction tacInstruction);

    String generate(StringLengthInstruction tacInstruction);

    String generate(NewStaticArrayInstruction tacInstruction);

    String generate(NewDynamicArrayInstruction tacInstruction);
}
