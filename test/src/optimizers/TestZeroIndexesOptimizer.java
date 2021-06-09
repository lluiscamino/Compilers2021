package src.optimizers;

import optimizers.TACOptimizer;
import optimizers.ZeroIndexesOptimizer;
import org.junit.Test;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.Collections;
import java.util.List;

public final class TestZeroIndexesOptimizer extends TestOptimizer {

    @Test
    public void testNonZeroIndexInIndexAssignmentInstructionIgnored() {
        TACVariable array = new TACVariable(0), variable = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new IndexAssignmentInstruction(array, new TACLiteral(1), variable)
        );
        TACOptimizer optimizer = new ZeroIndexesOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testZeroIndexInIndexAssignmentInstructionOptimized() {
        TACVariable array = new TACVariable(0), variable = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new IndexAssignmentInstruction(array, new TACLiteral(0), variable)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(array, variable)
        );
        TACOptimizer optimizer = new ZeroIndexesOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testNonZeroIndexInIndexedValueInstructionIgnored() {
        TACVariable variable = new TACVariable(0), array = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new IndexedValueInstruction(variable, array, new TACLiteral(1))
        );
        TACOptimizer optimizer = new ZeroIndexesOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testZeroIndexInIndexedValueInstructionOptimized() {
        TACVariable variable = new TACVariable(0), array = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new IndexedValueInstruction(variable, array, new TACLiteral(0))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, array)
        );
        TACOptimizer optimizer = new ZeroIndexesOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }
}
