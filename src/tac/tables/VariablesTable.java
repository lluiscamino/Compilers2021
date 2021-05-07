package tac.tables;

import main.Compiler;
import symboltable.Scope;
import tac.references.TACSubprogram;
import tac.references.TACVariable;

import java.util.ArrayList;
import java.util.List;

public final class VariablesTable {
    private final List<VariableInfo> variablesList = new ArrayList<>();

    public VariableInfo get(String name) {
        Scope scope = currentScope();
        VariableInfo variable = null;
        while (scope != null && variable == null) {
            variable = getVariableInScope(name, scope);
            scope = scope.getPrevious();
        }
        return variable;
    }

    public void add(TACVariable tacVariable, boolean subprogramArgument) {
        variablesList.add(new VariableInfo(tacVariable, currentSubprogram(), currentScope(), subprogramArgument));
    }

    public int size() {
        return variablesList.size();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Nombre\tSubprograma\tProfundidad\tParámetro\n");
        for (VariableInfo variableInfo : variablesList) {
            buffer.append(variableInfo.getTacVariable()).append("\t\t")
                    .append(variableInfo.getTacSubprogram() != null ? variableInfo.getTacSubprogram() : "--").append("\t\t\t")
                    .append(variableInfo.getScope().getIndentation()).append("\t\t\t").
                    append(variableInfo.isSubprogramArgument() ? "Sí" : "No").append("\n");
        }
        return buffer.toString();
    }

    private TACSubprogram currentSubprogram() {
        return currentScope().getTacSubprogram();
    }

    private Scope currentScope() {
        return Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable().getScope();
    }

    private VariableInfo getVariableInScope(String variableName, Scope scope) {
        for (VariableInfo variableInfo : variablesList) {
            if (variableInfo.getTacVariable().toString().equals(variableName) && variableInfo.getScope() == scope) {
                return variableInfo;
            }
        }
        return null;
    }

    public static final class VariableInfo {
        private final TACVariable tacVariable;
        private final TACSubprogram tacSubprogram;
        private final Scope scope;
        private final boolean subprogramArgument;

        public VariableInfo(TACVariable tacVariable, TACSubprogram tacSubprogram, Scope scope, boolean subprogramArgument) {
            this.tacVariable = tacVariable;
            this.tacSubprogram = tacSubprogram;
            this.scope = scope;
            this.subprogramArgument = subprogramArgument;
        }

        public TACVariable getTacVariable() {
            return tacVariable;
        }

        public TACSubprogram getTacSubprogram() {
            return tacSubprogram;
        }

        public Scope getScope() {
            return scope;
        }

        public boolean isSubprogramArgument() {
            return subprogramArgument;
        }
    }
}
