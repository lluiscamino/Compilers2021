package errors;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class SemanticError extends ProgramError {
    
    public SemanticError(String message, Location location) {
        super(message, location);
    }

    @Override
    public String getMessage() {
        int lineNum = location != null ? location.getLine() : -1;
        return "Error semántico (línea: " + lineNum + "): " + message;
    }
    
}
