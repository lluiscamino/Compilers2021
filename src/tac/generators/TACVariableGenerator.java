package tac.generators;

import main.Compiler;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public class TACVariableGenerator extends TACReferenceGenerator {
    private int nextIdDesc = Integer.MAX_VALUE;

    @Override
    public TACVariable generate() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable variable = new TACVariable(nextId++);
        variablesTable.add(variable, false);
        return variable;
    }

    public TACVariable generate(String identifier, boolean subprogramArgument) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable variable = new TACVariable(nextIdDesc--, identifier);
        variablesTable.add(variable, subprogramArgument);
        return variable;
    }
}
