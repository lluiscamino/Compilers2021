package main;

import java.io.FileNotFoundException;

public final class Main {
    private static final String INPUT_PATH = "C:\\Users\\lluis\\Desktop\\program.txt";
    private static final String TOKENS_PATH = "C:\\Users\\lluis\\Desktop\\tokens.dot";
    private static final String DOT_PATH = "C:\\Users\\lluis\\Desktop\\tree.dot";
    
    private Main() {}
    
    public static void main(String[] args) throws FileNotFoundException, Exception {
        Compiler compiler = new Compiler(INPUT_PATH);
        compiler.writeTokenList(TOKENS_PATH);
        compiler.parse();
        compiler.toDot(DOT_PATH);
    }
}
