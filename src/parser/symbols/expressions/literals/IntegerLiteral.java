package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACLiteral;

public final class IntegerLiteral extends Literal {
    
    public IntegerLiteral(int value, Location location) {
        super(value, Type.getInteger(), location);
    }
    
    @Override
    public Integer getValue() {
        return (int) literalValue;
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("INT_LIT", "box", "filled", "#f2ad46");
        
        dotNode.addEdge(() -> {
             new DotNode(Integer.toString(getValue()), "plaintext", "", "");
        }, "value");
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = main.Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        tacVariable = tacVariableGenerator.generate(Type.getInteger());  // t = novavar
        addTACInstruction(new CopyInstruction(tacVariable, new TACLiteral(getValue())));  //genera(t = lit)
    }
}
