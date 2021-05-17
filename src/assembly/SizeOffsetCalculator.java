package assembly;

import tac.tables.SubprogramsTable;
import tac.tables.VariablesTable;

public final class SizeOffsetCalculator {
    public void calculate(SubprogramsTable subprogramsTable, VariablesTable variablesTable) {
        for (VariablesTable.VariableInfo variableInfo : variablesTable.getVariablesList()) {
            SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get(variableInfo.getTacSubprogram());
            if (subprogramInfo == null) { // global variable
                continue;
            }
            int variableSize = variableInfo.getSize();
            int offset;
            if (variableInfo.isSubprogramArgument()) {
                subprogramInfo.setLocalParametersSize(subprogramInfo.getLocalParametersSize() + 8); // params are sent as addresses
                offset = subprogramInfo.getLocalParametersSize();
            } else {
                if (subprogramInfo.getLocalVariablesSize() == 0) {
                    subprogramInfo.setLocalVariablesSize(subprogramInfo.getLocalParametersSize());
                }
                subprogramInfo.setLocalVariablesSize(subprogramInfo.getLocalVariablesSize() + variableSize);
                offset = -subprogramInfo.getLocalVariablesSize();
            }
            variableInfo.setOffset(offset);
        }
    }
}
