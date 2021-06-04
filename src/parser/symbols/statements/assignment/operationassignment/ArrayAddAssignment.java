package parser.symbols.statements.assignment.operationassignment;

import dot.DotNode;
import parser.symbols.ArrayIndexes;
import parser.symbols.expressions.Expression;
import tac.instructions.arithmetic.AddInstruction;
import tac.references.TACVariable;

public final class ArrayAddAssignment extends ArrayOperationAssignment {
    public ArrayAddAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, indexes, expression);
    }

    @Override
    public void operationToTac(TACVariable variable) {
        addTACInstruction(new AddInstruction(variable, variable, expression.getTacVariable()));
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_ADD_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "+=");
    }
}
