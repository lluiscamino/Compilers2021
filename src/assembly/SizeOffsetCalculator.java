package assembly;

import tac.tables.SubprogramsTable;
import tac.tables.VariablesTable;

public final class SizeOffsetCalculator {
    public void calculate(SubprogramsTable subprogramsTable, VariablesTable variablesTable) {
        for (VariablesTable.VariableInfo variableInfo : variablesTable.getVariablesList()) {
            SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get(variableInfo.getTacSubprogram());
            int variableSize = variableInfo.getSize();
            subprogramInfo.setLocalVariablesSize(subprogramInfo.getLocalVariablesSize() + variableSize);
            int offset = subprogramInfo.getLocalVariablesSize();
            if (!variableInfo.isSubprogramArgument()) {
                offset = - offset;
            }
            variableInfo.setOffset(offset);
        }
    }
}
