package src.optimizers.peephole;

import optimizers.peephole.ConstantOperationsOptimizer;
import optimizers.peephole.PeepholeOptimizer;
import org.junit.Test;
import src.optimizers.TestOptimizer;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.*;
import tac.instructions.binary.AndInstruction;
import tac.instructions.binary.NotInstruction;
import tac.instructions.binary.OrInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

import java.util.Collections;
import java.util.List;

public final class TestConstantOperationsOptimizer extends TestOptimizer {

    @Test
    public void testNonConstantOperationIgnored() {
        TACVariable firstVariable = new TACVariable(0), secondVariable = new TACVariable(1);
        TACLiteral three = new TACLiteral(3);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new AddInstruction(firstVariable, secondVariable, three)
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, unoptimizedInstructions);
    }

    @Test
    public void testConstantAddOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        TACLiteral one = new TACLiteral(1), three = new TACLiteral(3);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new AddInstruction(variable, one, three)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(4))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantSubtractOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        TACLiteral one = new TACLiteral(1), three = new TACLiteral(3);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new SubtractInstruction(variable, three, one)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(2))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantProductOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        TACLiteral two = new TACLiteral(2), six = new TACLiteral(6);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ProductInstruction(variable, six, two)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(12))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantDivideOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        TACLiteral three = new TACLiteral(3), nine = new TACLiteral(9);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new DivideInstruction(variable, nine, three)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(3))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantModuloOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        TACLiteral two = new TACLiteral(2), five = new TACLiteral(5);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new ModuloInstruction(variable, five, two)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(1))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantNegativeOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        TACLiteral three = new TACLiteral(3);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new NegativeInstruction(variable, three)
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(-3))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantAndOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new AndInstruction(variable, new TACLiteral(true), new TACLiteral(false))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(false))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantOrOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new OrInstruction(variable, new TACLiteral(true), new TACLiteral(false))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(true))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }

    @Test
    public void testConstantNotOperationOptimized() {
        TACVariable variable = new TACVariable(0);
        List<TACInstruction> unoptimizedInstructions = Collections.singletonList(
                new NotInstruction(variable, new TACLiteral(true))
        );
        List<TACInstruction> expectedOptimizedInstructions = Collections.singletonList(
                new CopyInstruction(variable, new TACLiteral(false))
        );
        PeepholeOptimizer optimizer = new ConstantOperationsOptimizer(unoptimizedInstructions);
        List<TACInstruction> optimizedInstructions = optimizer.optimize();
        assertEqualTACInstructionLists(optimizedInstructions, expectedOptimizedInstructions);
    }
}
