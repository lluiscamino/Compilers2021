package parser.symbols.expressions.literals;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACLiteral;

import static assembly.x86.AssemblyCodeGenerationConstants.FALSE;
import static assembly.x86.AssemblyCodeGenerationConstants.TRUE;

public class BooleanLiteral extends Literal {
    
    public BooleanLiteral(boolean value, Location location) {
        super(value, Type.getBoolean(), location);
    }
    
    @Override
    public Boolean getValue() {
        return (boolean) literalValue;
    }
    
    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("BOOL_LIT", "box", "filled", "#f2ad46");
        
        dotNode.addEdge(() -> {
            new DotNode(String.valueOf(getValue()), "plaintext", "", "");
        }, "value");
    }

    @Override
    public void toTac() {
        TACVariableGenerator tacVariableGenerator = main.Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        tacVariable = tacVariableGenerator.generate(Type.getBoolean());  // t = novavar
        addTACInstruction(new CopyInstruction(tacVariable, new TACLiteral(getValue() ? TRUE : FALSE)));  //genera(t = lit)
    }
}
