package parser.symbols;

import dot.DOTizable;
import errors.SemanticError;
import main.Compiler;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;
import tac.TACizable;
import tac.instructions.TACInstruction;

import java.util.List;

public abstract class ParserSymbol extends ComplexSymbol implements DOTizable, TACizable {
    
    public ParserSymbol(String name) {
        super(name, 0);
    }
    
    public ParserSymbol(String name, Location location) {
        super(name, 0);
        this.xleft = location;
    }
    
    public abstract void validate();
    
    @Override
    public abstract void toDot();

    @Override
    public abstract void toTac();

    public void addTACInstruction(TACInstruction instruction) {
        List<TACInstruction> instructionList = Compiler.getCompiler().getSemanticAnalyzer().getTacInstructionList();
        instructionList.add(instruction);
    }
    
    public void addSemanticError(String message) {
        Compiler.getCompiler().getErrorsList().add(new SemanticError(message, xleft));
    }

    public void addSemanticError(String message, Location location) {
        Compiler.getCompiler().getErrorsList().add(new SemanticError(message, location));
    }
}
