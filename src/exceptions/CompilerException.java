package exceptions;

import java_cup.runtime.ComplexSymbolFactory.Location;


public abstract class CompilerException extends Exception {
    protected String message;
    protected Location leftLocation, rightLocation;
    
    public CompilerException(String message, Location leftLocation, Location rightLocation) {}
    
    @Override
    public abstract String getMessage();
}
