package optimizers.utils.flowgraphbuilder;

import optimizers.utils.BasicBloc;
import tac.instructions.TACInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfInstruction;
import tac.instructions.subprogram.calls.CallInstruction;
import tac.instructions.subprogram.returns.ReturnInstruction;
import tac.references.TACTag;
import tac.tables.SubprogramsTable;

import java.util.*;

public final class FlowGraphBuilder {
    private final List<TACInstruction> instructions;
    private final SubprogramsTable subprogramsTable;
    private final Map<TACTag, BasicBloc> tagToBasicBloc = new HashMap<>();

    public FlowGraphBuilder(List<TACInstruction> instructions, SubprogramsTable subprogramsTable) {
        this.instructions = instructions;
        this.subprogramsTable = subprogramsTable;
    }

    public Collection<BasicBloc> buildFlowGraph() {
        return buildBasicBlocs(identifyLeaders());
    }

    private Map<Integer, BasicBloc> identifyLeaders() {
        Map<Integer, BasicBloc> leaders = new HashMap<>();

        for (int i = 0; i < instructions.size(); i++) {
            TACInstruction instruction = instructions.get(i);
            if (instruction instanceof SkipInstruction) {
                BasicBloc basicBloc = new BasicBloc(leaders.size(), i);
                leaders.put(i, basicBloc);
                tagToBasicBloc.put((TACTag) instruction.getFirstReference(), basicBloc);
            } else if (instruction instanceof IfInstruction) {
                TACInstruction nextInstruction = nextInstruction(i);
                if (nextInstruction instanceof IfInstruction || nextInstruction instanceof GotoInstruction ||
                        nextInstruction instanceof ReturnInstruction || nextInstruction instanceof SkipInstruction) {
                    continue;
                }
                BasicBloc basicBloc = new BasicBloc(leaders.size(), i + 1);
                leaders.put(i + 1, basicBloc);
            }
        }
        addStartBasicBloc(leaders);
        addEndBasicBloc(leaders);
        return leaders;
    }

    private void addStartBasicBloc(Map<Integer, BasicBloc> leaders) {
        leaders.put(-1, BasicBloc.generateStart());
    }

    private void addEndBasicBloc(Map<Integer, BasicBloc> leaders) {
        leaders.put(-2, BasicBloc.generateEnd());
    }

    private Collection<BasicBloc> buildBasicBlocs(Map<Integer, BasicBloc> leaders) {
        int firstInstructionLine = firstProgramInstructionLine();
        startBasicBloc(leaders).addSuccessor(leaders.get(firstInstructionLine));
        for (BasicBloc basicBloc : leaders.values()) {
            if (basicBloc.isStartOrEndBasicBloc()) {
                continue;
            }
            int i = basicBloc.getStartLineNumber();
            while (!firstEndingBasicBlocInstruction(++i));
            TACInstruction instruction = instructions.get(i);
            while (instruction instanceof IfInstruction) {
                basicBloc.addSuccessor(tagToBasicBloc.get(instruction.getThirdReference()));
                i = i + 1;
                instruction = instructions.get(i);
            }
            if (instruction instanceof GotoInstruction) {
                basicBloc.addSuccessor(tagToBasicBloc.get(instruction.getFirstReference()));
                basicBloc.setEndLineNumber(i);
            }  else if (instruction instanceof CallInstruction) {
                SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get(((CallInstruction) instruction).getSubprogram());
                basicBloc.addSuccessor(tagToBasicBloc.get(subprogramInfo.getTag()));
                basicBloc.setEndLineNumber(i);
            } else if (instruction instanceof ReturnInstruction) {
                basicBloc.addSuccessor(endBasicBloc(leaders));
                basicBloc.setEndLineNumber(i);
            } else {
                basicBloc.addSuccessor(getBasicBloc(leaders.values(), basicBloc.getId() + 1));
                basicBloc.setEndLineNumber(i - 1);
            }
        }
        return leaders.values();
    }

    private int firstProgramInstructionLine() {
        for (int i = 0; i < instructions.size(); i++) {
            TACInstruction instruction = instructions.get(i);
            if (instruction instanceof SkipInstruction && ((TACTag) instruction.getFirstReference()).isMain()) {
                return i;
            }
        }
        throw new RuntimeException("First program instruction not found");
    }

    private boolean firstEndingBasicBlocInstruction(int instructionIndex) {
        TACInstruction instruction = instructions.get(instructionIndex);
        return instruction instanceof IfInstruction || instruction instanceof GotoInstruction ||
                instruction instanceof CallInstruction || instruction instanceof ReturnInstruction ||
                instruction instanceof SkipInstruction;
    }

    private BasicBloc getBasicBloc(Collection<BasicBloc> basicBlocs, int id) {
        for (BasicBloc basicBloc : basicBlocs) {
            if (basicBloc.getId() == id) {
                return basicBloc;
            }
        }
        return null;
    }

    private BasicBloc startBasicBloc(Map<Integer, BasicBloc> basicBlocs) {
        return basicBlocs.get(-1);
    }

    private BasicBloc endBasicBloc(Map<Integer, BasicBloc> basicBlocs) {
        return basicBlocs.get(-2);
    }

    private TACInstruction nextInstruction(int index) {
        int nextInstructionIndex = index + 1;
        return nextInstructionIndex < instructions.size() ? instructions.get(nextInstructionIndex) : null;
    }
}
