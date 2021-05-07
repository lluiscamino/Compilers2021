package parser.symbols.expressions;

import dot.DotNode;
import main.Compiler;
import parser.symbols.types.Type;
import tac.generators.TACTagGenerator;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfDiff;
import tac.references.TACLiteral;
import tac.references.TACTag;

public final class Conditional extends Expression {
    private final Expression condition, leftExpression, rightExpression;
    
    public Conditional(Expression condition, Expression leftExpression, Expression rightExpression) {
        super(Type.getUnknown(), Mode.RESULT, condition.xleft);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.condition = condition;
    }

    @Override
    public Type getType() {
        return leftExpression.getType();
    }

    @Override
    public void validate() {
        Type condType = condition.getType();
        Type leftExprType = leftExpression.getType();
        Type rightExprType = rightExpression.getType();
        boolean unknownType = leftExprType.isUnknown() || rightExprType.isUnknown();
        if (!condType.isUnknown() && !condType.isBoolean()) {
            addSemanticError("La condición de la expresión condicional debe ser de tipo " + Type.getBoolean() + ", no de tipo " + condType);
        }
        if (!unknownType && !leftExprType.equals(rightExprType)) {
            addSemanticError("Los tipos de las expresiones de una operación condicional deben ser iguales");
        }
        condition.validate();
        leftExpression.validate();
        rightExpression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("COND", "box", "filled", "#9077bf");
        
        dotNode.addEdge(condition, "cond");
        dotNode.addEdge(leftExpression);
        dotNode.addEdge(rightExpression);
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        TACTagGenerator tacTagGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacTagGenerator();

        condition.toTac();

        tacVariable = tacVariableGenerator.generate();
        TACTag e1 = tacTagGenerator.generate();
        TACTag e2 = tacTagGenerator.generate();

        addTACInstruction(new IfDiff(condition.getTacVariable(), new TACLiteral(0), e1));
        leftExpression.toTac();
        addTACInstruction(new CopyInstruction(tacVariable, leftExpression.getTacVariable()));
        addTACInstruction(new GotoInstruction(e2));
        addTACInstruction(new SkipInstruction(e1));
        rightExpression.toTac();
        addTACInstruction(new CopyInstruction(tacVariable, rightExpression.getTacVariable()));
        addTACInstruction(new SkipInstruction(e2));
    }
}
