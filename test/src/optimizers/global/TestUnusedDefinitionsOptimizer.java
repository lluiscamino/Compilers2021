package src.optimizers.global;

import optimizers.global.GlobalOptimizer;
import optimizers.global.UnusedDefinitionsOptimizer;
import org.junit.Test;
import src.optimizers.TestOptimizer;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.io.print.PrintIntInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TestUnusedDefinitionsOptimizer extends TestOptimizer {

    @Test
    public void testUsedDefinitionIgnored() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Arrays.asList(
                new CopyInstruction(variable, new TACLiteral(0)),
                new PrintIntInstruction(variable)
        );
        GlobalOptimizer optimizer = new UnusedDefinitionsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testUnusedDefinitionOptimized() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(0))
        );
        GlobalOptimizer optimizer = new UnusedDefinitionsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assert optimizedInstructions.isEmpty();
    }
}
