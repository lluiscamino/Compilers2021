package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACLiteral;

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
        
        dotNode.addEdge(() -> new DotNode(getValue(), "plaintext", "", ""), "value");
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = main.Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        tacVariable = tacVariableGenerator.generate(Type.getString());
        String str = getValue().substring(0, getValue().length() - 1) + "\\n\"";
        addTACInstruction(new CopyInstruction(tacVariable, new TACLiteral(str)));
    }
}
