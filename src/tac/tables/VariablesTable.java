package tac.tables;

import main.Compiler;
import parser.symbols.types.Type;
import symboltable.Scope;
import tac.references.TACSubprogram;
import tac.references.TACVariable;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class VariablesTable {
    private final List<VariableInfo> variablesList = new ArrayList<>();
    private int globalVariablesSize = 0;

    public List<VariableInfo> getVariablesList() {
        return variablesList;
    }

    public VariableInfo get(String name) {
        Scope scope = currentScope();
        VariableInfo variable = null;
        while (scope != null && variable == null) {
            variable = getVariableInScope(name, scope);
            scope = scope.getPrevious();
        }
        return variable;
    }

    public int getGlobalVariablesSize() {
        return globalVariablesSize;
    }

    public void setGlobalVariablesSize(int globalVariablesSize) {
        this.globalVariablesSize = globalVariablesSize;
    }

    public VariableInfo get(TACVariable tacVariable) {
        for (VariableInfo variableInfo : variablesList) {
            if (variableInfo.getTacVariable() == tacVariable) {
                return variableInfo;
            }
        }
        return null;
    }

    public void add(TACVariable tacVariable, Type type, int size, boolean subprogramArgument) {
        variablesList.add(new VariableInfo(tacVariable, type, currentSubprogram(), currentScope(), size, subprogramArgument));
    }

    public void remove(VariableInfo removedVariableInfo) {
        for (VariableInfo variableInfo : variablesList) {
            if (variableInfo == removedVariableInfo) {
                variablesList.remove(removedVariableInfo);
                return;
            }
        }
    }

    public int size() {
        return variablesList.size();
    }

    @Override
    public String toString() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Optional<VariableInfo> longestVariable = variablesList.stream()
                .reduce((variable1, variable2)
                        -> variable1.getTacVariable().toString().length() > variable2.getTacVariable().toString().length()
                        ? variable1 : variable2);
        int longestVariableName = Math.max(longestVariable.map(info -> info.getTacVariable().toString().length()).orElse(0), 10);
        String format = "%" + longestVariableName + "s%12s%12s%10s%10s%10s%16s\n";

        printWriter.println("Tamaño variables globales: " + globalVariablesSize);
        printWriter.format(format, "Nombre", "Subprograma", "Profundidad", "Parámetro", "Tipo", "Tamaño", "Desplazamiento");
        for (VariableInfo variableInfo : variablesList) {
            printWriter.format(format,
                    variableInfo.getTacVariable(),
                    variableInfo.getTacSubprogram() != null ? variableInfo.getTacSubprogram() : "--",
                    variableInfo.getScope().getIndentation(),
                    variableInfo.isSubprogramArgument() ? "Sí" : "No",
                    variableInfo.getType(),
                    variableInfo.getSize() + "B",
                    variableInfo.getOffset()
            );
        }
        return stringWriter.toString();
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
        private final Type type;
        private final TACSubprogram tacSubprogram;
        private final Scope scope;
        private final boolean subprogramArgument;
        private final int size;
        private int offset;

        public VariableInfo(TACVariable tacVariable, Type type, TACSubprogram tacSubprogram, Scope scope, int size, boolean subprogramArgument) {
            this.tacVariable = tacVariable;
            this.type = type;
            this.tacSubprogram = tacSubprogram;
            this.scope = scope;
            this.size = size;
            this.subprogramArgument = subprogramArgument;
        }

        public TACVariable getTacVariable() {
            return tacVariable;
        }

        public Type getType() {
            return type;
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

        public int getSize() {
            return size;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
    }
}
