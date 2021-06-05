package src.optimizers;

import optimizers.ArithmeticOperationsOptimizer;
import optimizers.TACOptimizer;
import org.junit.Test;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.DivideInstruction;
import tac.instructions.arithmetic.ModuloInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.Collections;
import java.util.List;

public final class TestArithmeticOperationsOptimizer extends TestOptimizer {

    @Test
    public void testMultiplicationByTwoIgnored() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ProductInstruction(variable1, variable2, new TACLiteral(2))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testMultiplicationByOneOptimized() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ProductInstruction(variable1, variable2, new TACLiteral(1))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable1, variable2)
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testMultiplicationByOneRemoved() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ProductInstruction(variable, variable, new TACLiteral(1))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, Collections.emptyList());
    }

    @Test
    public void testDivisionByTwoIgnored() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new DivideInstruction(variable1, variable2, new TACLiteral(2))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testDivisionByOneOptimized() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new DivideInstruction(variable1, variable2, new TACLiteral(1))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable1, variable2)
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testDivisionByOneRemoved() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new DivideInstruction(variable, variable, new TACLiteral(1))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, Collections.emptyList());
    }

    @Test
    public void testModuloByTwoIgnored() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ModuloInstruction(variable1, variable2, new TACLiteral(2))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testModuloByOneOptimized() {
        TACVariable variable1 = new TACVariable(0), variable2 = new TACVariable(1);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ModuloInstruction(variable1, variable2, new TACLiteral(1))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable1, new TACLiteral(0))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testModuloByOneNotRemoved() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ModuloInstruction(variable, variable, new TACLiteral(1))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(0))
        );
        TACOptimizer optimizer = new ArithmeticOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }
}
