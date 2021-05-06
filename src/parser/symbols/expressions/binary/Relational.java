package parser.symbols.expressions.binary;

import dot.DotNode;
import main.Compiler;
import parser.symbols.RelationalOperatorType;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import tac.generators.TACTagGenerator;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.references.TACLiteral;
import tac.references.TACTag;
import tac.references.TACVariable;

public final class Relational extends Expression {
    private final Expression leftExpression, rightExpression;
    private final RelationalOperatorType operator;

    public Relational(Expression leftExpression, RelationalOperatorType operator, Expression rightExpression) {
        super(Type.getBoolean(), Mode.RESULT, leftExpression.xleft);
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    @Override
    public void validate() {
        Type leftExprType = leftExpression.getType();
        Type rightExprType = rightExpression.getType();
        boolean unknownType = leftExprType.isUnknown() || rightExprType.isUnknown();
        if (!unknownType && !(leftExprType.equals(rightExprType))) {
            addSemanticError("No se pueden comparar tipos diferentes (" + leftExprType + " y " + rightExprType + ")");
        }
        if (!unknownType && !validType(leftExprType)) {
            addSemanticError("No se pueden comparar expresiones de tipo " + leftExprType);
        }
        leftExpression.validate();
        rightExpression.validate();
    }
    
    private boolean validType(Type type) {
        if (type.isInteger()) return true;
        if (type.isBoolean() || type.isString() || type.isArray()) {
            return operator == RelationalOperatorType.EQUAL ||
                    operator == RelationalOperatorType.DIFF;
        }
        return false;
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("RELATIONAL", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(leftExpression);
        dotNode.addEdgeIfNotNull(operator, "operator");
        dotNode.addEdgeIfNotNull(rightExpression);
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        TACTagGenerator tacTagGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacTagGenerator();

        leftExpression.toTac();
        rightExpression.toTac();

        tacVariable = tacVariableGenerator.generate();
        TACTag e1 = tacTagGenerator.generate();
        TACTag e2 = tacTagGenerator.generate();

        addTACInstruction(getIfInstruction(e1));
        addTACInstruction(new CopyInstruction(tacVariable, new TACLiteral(0)));
        addTACInstruction(new GotoInstruction(e2));
        addTACInstruction(new SkipInstruction(e1));
        addTACInstruction(new CopyInstruction(tacVariable, new TACLiteral(-1)));
        addTACInstruction(new SkipInstruction(e2));
    }

    private IfInstruction getIfInstruction(TACTag e1) {
        return switch (operator) {
            case LESS -> new IfLess(leftExpression.getTacVariable(), rightExpression.getTacVariable(), e1);
            case GREATER -> new IfGreater(leftExpression.getTacVariable(), rightExpression.getTacVariable(), e1);
            case LEQ -> new IfLEQ(leftExpression.getTacVariable(), rightExpression.getTacVariable(), e1);
            case GEQ -> new IfGEQ(leftExpression.getTacVariable(), rightExpression.getTacVariable(), e1);
            case EQUAL -> new IfEqual(leftExpression.getTacVariable(), rightExpression.getTacVariable(), e1);
            case DIFF -> new IfDiff(leftExpression.getTacVariable(), rightExpression.getTacVariable(), e1);
        };
    }
}
