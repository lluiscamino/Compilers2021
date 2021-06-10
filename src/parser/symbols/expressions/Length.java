package parser.symbols.expressions;

import dot.DotNode;
import main.Compiler;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.indexation.indexedvalue.ZeroIndexedValueInstruction;
import tac.instructions.length.StringLengthInstruction;

public final class Length extends Expression {
    private final Expression expression;
    
    public Length(Expression expression) {
        super(Type.getInteger(), Mode.RESULT, expression.xleft);
        this.expression = expression;
    }

    @Override
    public void validate() {
        Type type = expression.getType();
        if (!type.isUnknown() && !type.isArray() && !type.isString()) {
            addSemanticError("No se puede aplicar LENGTH a un valor de tipo " + type);
        }
        expression.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("LENGTH", "box", "filled", "#9077bf");
        
        dotNode.addEdge(expression, "expr");
    }

    @Override
    public void toTac() {
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        expression.toTac();
        tacVariable = variableGenerator.generate(Type.getInteger());
        if (expression.getType().isArray()) {
            addTACInstruction(new ZeroIndexedValueInstruction(tacVariable, expression.getTacVariable()));
        } else {
            addTACInstruction(new StringLengthInstruction(tacVariable, expression.getTacVariable()));
        }
    }
}
