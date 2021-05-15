package parser.symbols.expressions.io;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import main.Compiler;
import parser.symbols.types.Type;
import parser.symbols.expressions.Expression;
import tac.generators.TACVariableGenerator;
import tac.instructions.io.ReadInstruction;

public final class Read extends Expression {
    
    public Read(Location location) {
        super(Type.getString(), Mode.CONST, location);
    }

    @Override
    public void validate() {
        
    }

    @Override
    public void toDot() {
        new DotNode("READ", "box", "filled", "#8b7888");
    }

    @Override
    public void toTac() {
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        tacVariable = variableGenerator.generate(Type.getString());
        addTACInstruction(new ReadInstruction(tacVariable));
    }
}
