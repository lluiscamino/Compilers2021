package tac.references;

import main.Compiler;
import tac.tables.VariablesTable;

public final class TACVariable extends TACReference {
    private final String identifier;
    private final boolean temporal;

    public TACVariable(int id) {
        super(id);
        this.identifier = null;
        this.temporal = true;
    }

    @Override
    public int sizeInBytes() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        return variablesTable.get(this).getSize();
    }

    public TACVariable(int id, String identifier) {
        super(id);
        this.identifier = identifier;
        this.temporal = false;
    }

    public boolean isTemporal() {
        return temporal;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TACVariable)) {
            return false;
        }
        return ((TACVariable) obj).id == id;
    }

    @Override
    public String toString() {
        return identifier != null ? identifier : "t" + id;
    }
}
