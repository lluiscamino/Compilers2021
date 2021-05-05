package parser.symbols.statements.assignment.operationassignment;

import dot.DotNode;
import main.Compiler;
import parser.symbols.ArrayIndexes;
import parser.symbols.expressions.Expression;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public final class ArrayAddAssignment extends ArrayOperationAssignment {
    public ArrayAddAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, indexes, expression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_ADD_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "+=");
    }

    @Override
    public void toTac() {
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        indexes.toTac();
        expression.toTac();

        TACVariable arrayReference = variablesTable.get(identifier).getTacVariable();
        TACVariable temp = variableGenerator.generate();
        TACVariable offset = indexes.getOffset();

        addTACInstruction(new IndexAssignmentInstruction(temp, arrayReference, offset));
        addTACInstruction(new AddInstruction(temp, temp, expression.getTacVariable()));
        addTACInstruction(new IndexAssignmentInstruction(arrayReference, offset, temp));
    }
}
