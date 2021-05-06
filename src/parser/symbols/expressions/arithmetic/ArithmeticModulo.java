package parser.symbols.expressions.arithmetic;

import dot.DotNode;
import main.Compiler;
import parser.symbols.expressions.Expression;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.ModuloInstruction;
import tac.references.TACVariable;

public final class ArithmeticModulo extends ArithmeticOperation {
    
    public ArithmeticModulo(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("MOD", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        leftExpression.toTac();
        rightExpression.toTac();

        tacVariable = tacVariableGenerator.generate();  // t = novavar
        addTACInstruction(new ModuloInstruction(tacVariable, leftExpression.getTacVariable(), rightExpression.getTacVariable()));  //genera(t = E1.r mod E2.r)
    }
}
