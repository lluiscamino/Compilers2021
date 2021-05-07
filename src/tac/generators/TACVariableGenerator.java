package tac.generators;

import main.Compiler;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public class TACVariableGenerator extends TACReferenceGenerator {
    @Override
    public TACVariable generate() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable variable = new TACVariable(nextId++);
        variablesTable.add(variable.toString(), variable, false);
        return variable;
    }

    public TACVariable generate(String identifier, boolean subprogramArgument) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable variable = new TACVariable(nextId++);
        variablesTable.add(identifier, variable, subprogramArgument);
        return variable;
    }
}
