package tac.generators;

import main.Compiler;
import parser.symbols.types.Type;
import tac.references.TACReference;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public class TACVariableGenerator extends TACReferenceGenerator {
    private int nextIdDesc = Integer.MAX_VALUE;

    @Override
    public TACReference generate() {
        throw new RuntimeException("Operation not permitted. Please indicate variable type");
    }

    public TACVariable generate(Type type) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable variable = new TACVariable(nextId++);
        variablesTable.add(variable, type, type.getPrimitiveType().sizeInBytes(), false); // todo: arrays and strings
        return variable;
    }

    public TACVariable generate(String identifier, Type type, boolean subprogramArgument) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable variable = new TACVariable(nextIdDesc--, identifier);
        variablesTable.add(variable, type, type.getPrimitiveType().sizeInBytes(),subprogramArgument);
        return variable;
    }
}
