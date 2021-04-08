package errors;

import java_cup.runtime.ComplexSymbolFactory.Location;

public abstract class ProgramError extends Exception {
    protected final String message;
    protected final Location location;
    
    public ProgramError(String message, Location location) {
        this.message = message;
        this.location = location;
    }
    
    @Override
    public abstract String getMessage();

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProgramError)) return false;
        ProgramError error = (ProgramError) object;
        return getClass().equals(error.getClass()) && message.equals(error.message)
                && (location == error.location || location.getLine() == error.location.getLine());
    }
}
