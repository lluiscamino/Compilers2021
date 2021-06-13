package optimizers.utils;

import tac.instructions.TACInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UnusedTACVariablesRemover {
    private final List<TACInstruction> instructionList;
    private final VariablesTable variablesTable;
    private final Set<TACVariable> usedVariables;

    public UnusedTACVariablesRemover(List<TACInstruction> instructionList, VariablesTable variablesTable) {
        this.instructionList = instructionList;
        this.variablesTable = variablesTable;
        this.usedVariables = new HashSet<>();
    }

    public void removeUnusedVariables() {
        List<VariablesTable.VariableInfo> removedVariables = new ArrayList<>();
        for (TACInstruction instruction : instructionList) {
            addIfVariable(instruction.getFirstReference());
            addIfVariable(instruction.getSecondReference());
            addIfVariable(instruction.getThirdReference());
        }
        for (VariablesTable.VariableInfo variableInfo : variablesTable.getVariablesList()) {
            TACVariable variable = variableInfo.getTacVariable();
            if (!usedVariables.contains(variable)) {
                removedVariables.add(variableInfo);
            }
        }
        for (VariablesTable.VariableInfo variableInfo : removedVariables) {
            variablesTable.remove(variableInfo);
        }
    }

    private void addIfVariable(TACReference reference) {
        if (reference instanceof TACVariable) {
            usedVariables.add((TACVariable) reference);
        }
    }
}
