package exceptions;

import java_cup.runtime.ComplexSymbolFactory.Location;

public final class LexicalError extends CompilerException {
    
    public LexicalError(String message, Location leftLocation, Location rightLocation) {
        super(message, leftLocation, rightLocation);
    }

    @Override
    public String getMessage() {
        return "Lexical Error: " + message;
    }
}
