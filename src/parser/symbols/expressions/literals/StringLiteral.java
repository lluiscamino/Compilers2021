package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;

public class StringLiteral extends Literal {
    
    public StringLiteral(String value, Location location) {
        super(value, Type.getString(), location);
    }
    
    @Override
    public String getValue() {
        return (String) literalValue;
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("STR_LIT", "box", "filled", "#f2ad46");
        
        dotNode.addEdge(() -> {
            new DotNode(getValue(), "plaintext", "", "");
        }, "value");
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = main.Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        TACVariable t = tacVariableGenerator.generate();  // t = novavar
        addTACInstruction(new CopyInstruction(t, new TACLiteral(value)));  //genera(t = lit)
        tacVariable = t;  //E0.r = t; 
    }
}
