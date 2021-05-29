package src.optimizers;

import optimizers.TACOptimizer;
import optimizers.UnusedTagsOptimizer;
import org.junit.Test;
import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.references.TACTag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TestUnusedTagsOptimizer extends TestOptimizer {

    @Test
    public void testUsedTagIgnored() {
        TACTag tag = new TACTag(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new GotoInstruction(tag),
                new SkipInstruction(tag)
        );
        TACOptimizer optimizer = new UnusedTagsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testUnusedTagIgnored() {
        TACTag tag = new TACTag(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new SkipInstruction(tag)
        );
        TACOptimizer optimizer = new UnusedTagsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assert optimizedInstructions.isEmpty();
    }
}
