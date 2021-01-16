package errors;

import java_cup.runtime.ComplexSymbolFactory.Location;

public abstract class ProgramError extends Exception {
    protected final String message;
    protected final Location leftLocation, rightLocation;
    
    public ProgramError(String message, Location leftLocation, Location rightLocation) {
        this.message = message;
        this.leftLocation = leftLocation;
        this.rightLocation = rightLocation;
    }
    
    @Override
    public abstract String getMessage();
}
