package src.optimizers;

import optimizers.ConstantIfsOptimizer;
import optimizers.TACOptimizer;
import org.junit.Test;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfEqual;
import tac.references.TACLiteral;
import tac.references.TACTag;
import tac.references.TACVariable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TestConstantIfsOptimizer extends TestOptimizer {

    @Test
    public void testNotConstantIfIgnored() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        TACLiteral zero = new TACLiteral(0), one = new TACLiteral(1);
        TACTag e1 = new TACTag(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new AddInstruction(variable1, variable2, one),
                new IfEqual(variable1, zero, e1)
        );
        TACOptimizer optimizer = new ConstantIfsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testConstantTrueIfOptimized() {
        TACLiteral zero = new TACLiteral(0);
        TACTag e1 = new TACTag(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new IfEqual(zero, zero, e1),
                new SkipInstruction(e1)
        );
        List<TACInstruction> expectedOptimizedInstructions = Arrays.asList(
                new GotoInstruction(e1),
                new SkipInstruction(e1)
        );
        TACOptimizer optimizer = new ConstantIfsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantFalseIfOptimized() {
        TACLiteral zero = new TACLiteral(0), one = new TACLiteral(1);
        TACTag e1 = new TACTag(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new IfEqual(zero, one, e1)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.emptyList();
        TACOptimizer optimizer = new ConstantIfsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }
}
