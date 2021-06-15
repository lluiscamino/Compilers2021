package src.optimizers.peephole;

import optimizers.peephole.PeepholeOptimizer;
import optimizers.peephole.UnusedTagsOptimizer;
import org.junit.Test;
import src.optimizers.TestOptimizer;
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
        PeepholeOptimizer optimizer = new UnusedTagsOptimizer(unoptimizedInstructions, null);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testMainTagIgnored() {
        TACTag tag = new TACTag(0, "t_main");
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new SkipInstruction(tag)
        );
        PeepholeOptimizer optimizer = new UnusedTagsOptimizer(unoptimizedInstructions, null);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testUnusedTagOptimized() {
        TACTag tag = new TACTag(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new SkipInstruction(tag)
        );
        PeepholeOptimizer optimizer = new UnusedTagsOptimizer(unoptimizedInstructions, null);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assert optimizedInstructions.isEmpty();
    }
}
