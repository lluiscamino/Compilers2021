package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;

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

        TACVariable t = tacVariableGenerator.generate();  // t = novavar
        addTACInstruction(new CopyInstruction(t, new TACLiteral(getValue())));  //genera(t = lit)
        tacVariable = t;  //E0.r = t;
    }
}
