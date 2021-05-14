import optimizers.DifferedAssignmentsOptimizer;
import optimizers.TACOptimizer;
import org.junit.Test;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.io.print.PrintIntInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TestDifferedAssignmentsOptimizer {

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
        TACOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
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
        TACOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
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
        TACOptimizer optimizer = new DifferedAssignmentsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    private void assertEqualTACInstructionLists(List<TACInstruction> list1, List<TACInstruction> list2) {
        assert list1.size() == list2.size();
        for (int i = 0; i < list1.size(); i++) {
            assert list1.get(i).toString().equals(list2.get(i).toString());
        }
    }
}
