package parser.symbols.statements.assignment.operationassignment;

import dot.DotNode;
import main.Compiler;
import parser.symbols.expressions.Expression;
import tac.instructions.arithmetic.SubtractInstruction;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public final class SubstractAssignment extends OperationAssignment {
    public SubstractAssignment(String identifier, Expression expression) {
        super(identifier, expression);
    }
    
    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("SUB_ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> new DotNode(identifier, "plaintext", "filled", ""), "ident");
        dotNode.addEdge(expression, "-=");
    }

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        TACVariable variable = variablesTable.get(identifier).getTacVariable();
        expression.toTac();
        addTACInstruction(new SubtractInstruction(variable, variable, expression.getTacVariable()));
    }
}
