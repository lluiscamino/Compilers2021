package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import main.Compiler;
import parser.symbols.expressions.Expression;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.DivideInstruction;
import tac.references.TACVariable;

public final class ArithmeticDivide extends ArithmeticOperation {

    public ArithmeticDivide(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("DIV", "box", "filled", "#9077bf");

        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        leftExpression.toTac();
        rightExpression.toTac();
        
        TACVariable t = tacVariableGenerator.generate();  // t = novavar
        addTACInstruction(new DivideInstruction(t, leftExpression.getTacVariable(), rightExpression.getTacVariable()));  //genera(t = E1.r / E2.r)
        tacVariable = t;  //E0.r = t;
    }
}
