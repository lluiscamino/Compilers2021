package src.optimizers.local;

import optimizers.local.CopyPropagationOptimizer;
import optimizers.local.LocalOptimizer;
import optimizers.utils.BasicBloc;
import optimizers.utils.flowgraphbuilder.FlowGraphBuilder;
import org.junit.Test;
import src.optimizers.TestOptimizer;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.subprogram.returns.ProcedureReturnInstruction;
import tac.references.TACLiteral;
import tac.references.TACTag;
import tac.references.TACVariable;
import tac.tables.SubprogramsTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class TestCopyPropagationOptimizer extends TestOptimizer {

    @Test
    public void testNonAvailableCopyNotOptimized() {
        TACTag mainTag = new TACTag(0, "t_main");
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1), variable3 = new TACVariable(2);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new SkipInstruction(mainTag),
                new CopyInstruction(variable1, variable2),
                new CopyInstruction(variable2, new TACLiteral(-7)),
                new AddInstruction(variable3, variable1, new TACLiteral(3)),
                new ProcedureReturnInstruction(null)
        );
        List<TACInstruction> unoptimizedInstructionsCopy = Arrays.asList(
                new SkipInstruction(mainTag),
                new CopyInstruction(variable1, variable2),
                new CopyInstruction(variable2, new TACLiteral(-7)),
                new AddInstruction(variable3, variable1, new TACLiteral(3)),
                new ProcedureReturnInstruction(null)
        );
        LocalOptimizer optimizer = new CopyPropagationOptimizer(unoptimizedInstructions, buildFlowGraph(unoptimizedInstructionsCopy));
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructionsCopy);
    }

    @Test
    public void testAvailableCopyOptimized() {
        TACTag mainTag = new TACTag(0, "t_main");
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1), variable3 = new TACVariable(2);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new SkipInstruction(mainTag),
                new CopyInstruction(variable1, variable2),
                new AddInstruction(variable3, variable1, new TACLiteral(3)),
                new ProcedureReturnInstruction(null)
        );
        List<TACInstruction> expectedOptimizedInstructions = Arrays.asList(
                new SkipInstruction(mainTag),
                new CopyInstruction(variable1, variable2),
                new AddInstruction(variable3, variable2, new TACLiteral(3)),
                new ProcedureReturnInstruction(null)
        );
        LocalOptimizer optimizer = new CopyPropagationOptimizer(new ArrayList<>(unoptimizedInstructions), buildFlowGraph(unoptimizedInstructions));
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    public Collection<BasicBloc> buildFlowGraph(List<TACInstruction> instructions) {
        FlowGraphBuilder flowGraphBuilder = new FlowGraphBuilder(instructions, new SubprogramsTable());
        return flowGraphBuilder.buildFlowGraph();
    }
}
