package errors;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class SyntaxError extends ProgramError {
    
    public SyntaxError(String message, Location location) {
        super(message, location);
    }

    @Override
    public String getMessage() {
        int lineNum = location != null ? location.getLine() : -1;
        return "Error sintáctico (línea: " + lineNum + "): " + message;
    }
    
}
