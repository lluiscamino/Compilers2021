package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import main.Compiler;
import parser.symbols.expressions.Expression;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.references.TACVariable;

public final class ArithmeticAdd extends ArithmeticOperation {

    public ArithmeticAdd(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ADD", "box", "filled", "#9077bf");

        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        leftExpression.toTac();
        rightExpression.toTac();

        tacVariable = tacVariableGenerator.generate();  // t = novavar
        addTACInstruction(new AddInstruction(tacVariable, leftExpression.getTacVariable(), rightExpression.getTacVariable()));  //genera(t = E1.r + E2.r)
    }
}
