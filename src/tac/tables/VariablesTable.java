package tac.tables;

import main.Compiler;
import symboltable.Scope;
import tac.references.TACSubprogram;
import tac.references.TACVariable;

import java.util.ArrayList;

public final class VariablesTable {
    public static final class VariableInfo {
        private String name;
        private TACVariable tacVariable;
        private TACSubprogram tacSubprogram;
        private Scope scope;
        private boolean subprogramArgument;

        public VariableInfo(String name, TACVariable tacVariable, TACSubprogram tacSubprogram, Scope scope, boolean subprogramArgument) {
            this.name = name;
            this.tacVariable = tacVariable;
            this.tacSubprogram = tacSubprogram;
            this.scope = scope;
            this.subprogramArgument = subprogramArgument;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TACVariable getTacVariable() {
            return tacVariable;
        }

        public void setTacVariable(TACVariable tacVariable) {
            this.tacVariable = tacVariable;
        }

        public TACSubprogram getTacSubprogram() {
            return tacSubprogram;
        }

        public void setTacSubprogram(TACSubprogram tacSubprogram) {
            this.tacSubprogram = tacSubprogram;
        }

        public Scope getScope() {
            return scope;
        }

        public void setScope(Scope scope) {
            this.scope = scope;
        }

        public boolean isSubprogramArgument() {
            return subprogramArgument;
        }

        public void setSubprogramArgument(boolean subprogramArgument) {
            this.subprogramArgument = subprogramArgument;
        }
    }

    private final ArrayList<VariableInfo> variablesList = new ArrayList<>();

    public VariableInfo get(String name) {
        Scope scope = currentScope();
        VariableInfo variable = null;
        while (scope != null && variable == null) {
            variable = getVariableInScope(name, scope);
            scope = scope.getPrevious();
        }
        return variable;
    }

    public void add(String name, TACVariable tacVariable, TACSubprogram tacSubprogram, boolean subprogramArgument) {
        variablesList.add(tacVariable.getId(),
                new VariableInfo(name, tacVariable, tacSubprogram, currentScope(), subprogramArgument));
    }

    public int size() {
        return variablesList.size();
    }

    private Scope currentScope() {
        return Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable().getScope();
    }

    private VariableInfo getVariableInScope(String variableName, Scope scope) {
        for (VariableInfo variableInfo : variablesList) {
            if (variableInfo.getName().equals(variableName) && variableInfo.getScope() == scope) {
                return variableInfo;
            }
        }
        return null;
    }
}
