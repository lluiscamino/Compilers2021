package errors;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class SemanticError extends ProgramError {
    
    public SemanticError(String message, Location leftLocation, Location rightLocation) {
        super(message, leftLocation, rightLocation);
    }

    @Override
    public String getMessage() {
        int lineNum = 0/*leftLocation.getLine()*/;
        int colNum = 0/*leftLocation.getColumn()*/;
        return "Error semántico (lin: " + lineNum + ", col: " + colNum + "): " + message;
    }
    
}
