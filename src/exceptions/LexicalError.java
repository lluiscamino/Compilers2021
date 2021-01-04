package exceptions;

public class LexicalError extends Exception {
    private final int line;
    
    public LexicalError(String message, int line) {
        super("Lexical Error (Line " + line + "):" + message);
        this.line = line;
    }

    public int getLine() {
        return line;
    }
}
