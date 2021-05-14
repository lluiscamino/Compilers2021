package src.optimizers;

import tac.instructions.TACInstruction;

import java.util.List;

public abstract class TestOptimizer {
    protected void assertEqualTACInstructionLists(List<TACInstruction> list1, List<TACInstruction> list2) {
        assert list1.size() == list2.size();
        for (int i = 0; i < list1.size(); i++) {
            assert list1.get(i).toString().equals(list2.get(i).toString());
        }
    }
}
