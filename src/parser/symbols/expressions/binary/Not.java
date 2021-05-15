package parser.symbols.expressions.binary;

import dot.DotNode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.binary.NotInstruction;
import tac.references.TACVariable;

public final class Not extends Expression {
    private final Expression expression;
    
    public Not(Expression expression) {
        super(Type.getBoolean(), Mode.RESULT, expression.xleft);
        this.expression = expression;
    }

    @Override
    public void validate() {
        Type exprType = expression.getType();
        if (!exprType.isUnknown() && !exprType.isBoolean()) {
            addSemanticError("No se puede hacer una operación lógica con un tipo que no sea " + Type.getBoolean());
        }

        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("NOT_EXPR", "box", "filled", "#9077bf");
        
        dotNode.addEdgeIfNotNull(expression, "expr");
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = main.Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        expression.toTac();

        tacVariable = tacVariableGenerator.generate(Type.getBoolean());  // t = novavar
        addTACInstruction(new NotInstruction(tacVariable, expression.getTacVariable()));  //genera(t = !E1.r)
    }
}
