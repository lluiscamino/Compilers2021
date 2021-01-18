package errors;

import java_cup.runtime.ComplexSymbolFactory.Location;

public final class LexicalError extends ProgramError {
    
    public LexicalError(String message, Location location) {
        super(message, location);
    }

    @Override
    public String getMessage() {
        int lineNum = location != null ? location.getLine() : -1;
        return "Error léxico (línea: " + lineNum + "): " + message;
    }
}
