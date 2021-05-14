package parser.symbols.statements.io;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import tac.instructions.io.print.PrintInstructionFactory;

public final class Print extends Statement {
    
    private final Expression expression;
    
    public Print(Expression expression) {
        super(expression.xleft);
        this.expression = expression;
    }

    @Override
    public void validate() {
        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("PRINT", "", "filled", "#5280d6");
        dotNode.addEdge(expression, "expr");
    }

    @Override
    public void toTac() {
        expression.toTac();

        PrintInstructionFactory printInstructionFactory = new PrintInstructionFactory();
        addTACInstruction(printInstructionFactory.get(expression));
    }
}
