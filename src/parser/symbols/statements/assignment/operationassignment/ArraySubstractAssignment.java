package parser.symbols.statements.assignment.operationassignment;

import dot.DotNode;
import main.Compiler;
import parser.symbols.ArrayIndexes;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.instructions.arithmetic.SubtractInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

import java.util.List;

public final class ArraySubstractAssignment extends ArrayOperationAssignment {
    public ArraySubstractAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, indexes, expression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_SUB_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "-=");
    }

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        VariablesTable.VariableInfo variableInfo = variablesTable.get(identifier);
        TACVariable variable = variableInfo.getTacVariable();
        TACVariable newVariable = variableGenerator.generate(variableInfo.getType());
        TACVariable realIndex = variableGenerator.generate(Type.getInteger());
        indexes.toTac();
        List<Expression> indexesList = indexes.getIndexes().toArrayList();
        TACVariable lastIndex = indexesList.get(indexesList.size() - 1).getTacVariable();

        addTACInstruction(new CopyInstruction(newVariable, variable));
        for (int i = 0; i < indexesList.size() - 1; i++) {
            Expression index = indexesList.get(i);
            addTACInstruction(new AddInstruction(realIndex, index.getTacVariable(), new TACLiteral(1)));
            addTACInstruction(new ProductInstruction(realIndex, realIndex, new TACLiteral(8)));
            addTACInstruction(new IndexedValueInstruction(newVariable, newVariable, realIndex));
        }
        expression.toTac();
        TACVariable temp = variableGenerator.generate(Type.getInteger());
        addTACInstruction(new AddInstruction(realIndex, lastIndex, new TACLiteral(1)));
        addTACInstruction(new ProductInstruction(realIndex, realIndex, new TACLiteral(8)));
        addTACInstruction(new IndexedValueInstruction(temp, newVariable, realIndex));
        addTACInstruction(new SubtractInstruction(temp, temp, expression.getTacVariable()));
        addTACInstruction(new IndexAssignmentInstruction(newVariable, realIndex, temp));
    }
}
