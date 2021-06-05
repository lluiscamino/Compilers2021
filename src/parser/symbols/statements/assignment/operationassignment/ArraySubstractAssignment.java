package parser.symbols.statements.assignment.operationassignment;

import dot.DotNode;
import parser.symbols.ArrayIndexes;
import parser.symbols.expressions.Expression;
import tac.instructions.arithmetic.SubtractInstruction;
import tac.references.TACVariable;

public final class ArraySubstractAssignment extends ArrayOperationAssignment {
    public ArraySubstractAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, indexes, expression);
    }

    @Override
    public void operationToTac(TACVariable variable) {
        addTACInstruction(new SubtractInstruction(variable, variable, expression.getTacVariable()));
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ARR_SUB_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> new DotNode(identifier, "plaintext", "filled", ""), "ident");
        dotNode.addEdge(expression, "-=");
    }
}
