package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;

public final class BinaryAnd extends BinaryOperation {
    
    public BinaryAnd(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("AND", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(rightExpression);
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = main.Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        
        TACVariable t = tacVariableGenerator.generate();  // t = novavar
        addTACInstruction(new AndInstruction(t, leftExpression.getTacVariable(), rightExpression.getTacVariable()));  //genera(t = E1.r && E2.r)
        tacVariable = t;  //E0.r = t;
    }
}
