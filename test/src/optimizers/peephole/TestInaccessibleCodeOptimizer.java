package src.optimizers.peephole;

import optimizers.peephole.InaccessibleCodeOptimizer;
import optimizers.peephole.PeepholeOptimizer;
import org.junit.Test;
import src.optimizers.TestOptimizer;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.references.TACLiteral;
import tac.references.TACTag;
import tac.references.TACVariable;

import java.util.Arrays;
import java.util.List;

public final class TestInaccessibleCodeOptimizer extends TestOptimizer {

    @Test
    public void testAccesibleCodeIgnored() {
        TACVariable variable = new TACVariable(0);
        TACTag tag1 = new TACTag(0), tag2 = new TACTag(1);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new SkipInstruction(tag1),
                new CopyInstruction(variable, new TACLiteral(0)),
                new SkipInstruction(tag2)
        );
        PeepholeOptimizer optimizer = new InaccessibleCodeOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testUnAccesibleCodeOptimized() {
        TACVariable variable = new TACVariable(0);
        TACTag tag1 = new TACTag(0), tag2 = new TACTag(1);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new SkipInstruction(tag1),
                new GotoInstruction(tag2),
                new CopyInstruction(variable, new TACLiteral(0)),
                new SkipInstruction(tag2)
        );
        List<TACInstruction> expectedOptimizedInstructions = Arrays.asList(
                new SkipInstruction(tag1),
                new GotoInstruction(tag2),
                new SkipInstruction(tag2)
        );
        PeepholeOptimizer optimizer = new InaccessibleCodeOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }
}
