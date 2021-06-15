package src.optimizers.peephole;

import optimizers.peephole.DifferedAssignmentsOptimizer;
import optimizers.peephole.PeepholeOptimizer;
import org.junit.Test;
import src.optimizers.TestOptimizer;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.indexation.indexassignment.IndexAssignmentInstruction;
import tac.instructions.io.print.PrintIntInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TestDifferedAssignmentsOptimizer extends TestOptimizer {

    @Test
    public void testUsedTemporalVariableIgnored() {
        TACVariable tempVariable = new TACVariable(0);
        TACVariable namedVariable = new TACVariable(1, "a");
        TACLiteral zero = new TACLiteral(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new CopyInstruction(tempVariable, zero),
                new PrintIntInstruction(tempVariable),
                new CopyInstruction(namedVariable, tempVariable)
        );
        PeepholeOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testUsedThreeTimesTemporalVariableIgnored() {
        TACVariable tempVariable = new TACVariable(0);
        TACVariable namedVariable = new TACVariable(1, "a");
        TACLiteral zero = new TACLiteral(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new CopyInstruction(tempVariable, zero),
                new PrintIntInstruction(tempVariable),
                new PrintIntInstruction(tempVariable),
                new PrintIntInstruction(tempVariable),
                new CopyInstruction(namedVariable, tempVariable)
        );
        PeepholeOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testSimpleDifferedAssigmentOptimized() {
        TACVariable tempVariable = new TACVariable(0);
        TACVariable namedVariable = new TACVariable(1, "a");
        TACLiteral zero = new TACLiteral(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new CopyInstruction(tempVariable, zero),
                new CopyInstruction(namedVariable, tempVariable)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(namedVariable, zero)
        );
        PeepholeOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testArrayDifferedAssigmentOptimized() {
        TACVariable
                tempVariable1 = new TACVariable(0),
                tempVariable2 = new TACVariable(1),
                tempVariable3 = new TACVariable(2),
                tempVariable4 = new TACVariable(3);
        TACVariable namedVariable = new TACVariable(1, "array");
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new CopyInstruction(tempVariable1, new TACLiteral(2)),
                new IndexAssignmentInstruction(tempVariable4, new TACLiteral(0), tempVariable1),
                new CopyInstruction(tempVariable2, new TACLiteral(10)),
                new IndexAssignmentInstruction(tempVariable4, new TACLiteral(1), tempVariable2),
                new CopyInstruction(tempVariable3, new TACLiteral(12)),
                new IndexAssignmentInstruction(tempVariable4, new TACLiteral(2), tempVariable3),
                new CopyInstruction(namedVariable, tempVariable4)
        );
        List<TACInstruction> expectedOptimizedInstructions = Arrays.asList(
                new IndexAssignmentInstruction(tempVariable4, new TACLiteral(0), new TACLiteral(2)),
                new IndexAssignmentInstruction(tempVariable4, new TACLiteral(1), new TACLiteral(10)),
                new IndexAssignmentInstruction(tempVariable4, new TACLiteral(2), new TACLiteral(12)),
                new CopyInstruction(namedVariable, tempVariable4)
        );
        PeepholeOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }
}
