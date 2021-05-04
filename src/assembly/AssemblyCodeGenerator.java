package assembly;

import tac.instructions.arithmetic.*;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.instructions.binary.AndInstruction;
import tac.instructions.binary.NotInstruction;
import tac.instructions.binary.OrInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.instructions.subprogram.*;

public interface AssemblyCodeGenerator {
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

    String generate(GotoInstruction tacInstruction);

    String generate(SkipInstruction tacInstruction);

    String generate(AndInstruction tacInstruction);

    String generate(NotInstruction tacInstruction);

    String generate(OrInstruction tacInstruction);

    String generate(IndexAssignmentInstruction tacInstruction);

    String generate(IndexedValueInstruction tacInstruction);

    String generate(CallInstruction tacInstruction);

    String generate(ComplexParameterInstruction tacInstruction);

    String generate(PreambleInstruction tacInstruction);

    String generate(ReturnInstruction tacInstruction);

    String generate(SimpleParameterInstruction tacInstruction);
}
