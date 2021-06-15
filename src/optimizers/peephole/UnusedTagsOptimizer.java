package optimizers.peephole;

import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfInstruction;
import tac.instructions.subprogram.calls.CallInstruction;
import tac.references.TACTag;
import tac.tables.SubprogramsTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UnusedTagsOptimizer extends PeepholeOptimizer {
    private final SubprogramsTable subprogramsTable;

    public UnusedTagsOptimizer(List<TACInstruction> unoptimizedInstructions, SubprogramsTable subprogramsTable) {
        super(unoptimizedInstructions);
        this.subprogramsTable = subprogramsTable;
    }

    @Override
    public List<TACInstruction> optimize() {
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        Set<TACTag> usedTags = new HashSet<>();
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (instruction instanceof IfInstruction) {
                usedTags.add((TACTag) instruction.getThirdReference());
            } else if (instruction instanceof GotoInstruction) {
                usedTags.add((TACTag) instruction.getFirstReference());
            } else if (instruction instanceof CallInstruction) {
                SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get(((CallInstruction) instruction).getSubprogram());
                usedTags.add(subprogramInfo.getTag());
            }
        }
        for (TACInstruction instruction : unoptimizedInstructions) {
            if (!(instruction instanceof SkipInstruction) ||usedTags.contains(instruction.getFirstReference()) ||
                    ((TACTag) instruction.getFirstReference()).isMain()) {
                optimizedInstructions.add(instruction);
            }
        }
        return optimizedInstructions;
    }
}
