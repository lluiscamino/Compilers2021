package main;

import java.io.FileNotFoundException;

public final class Main {
    private static final String INPUT_PATH = "C:\\Users\\lluis\\Desktop\\program.txt";
    private static final String TOKENS_PATH = "C:\\Users\\lluis\\Desktop\\tokens.dot";
    private static final String SYMBOL_TABLE_PATH = "C:\\Users\\lluis\\Desktop\\symbol_table.dot";
    private static final String TREE_PATH = "C:\\Users\\lluis\\Desktop\\tree.dot";
    private static final String ERRORS_PATH = "C:\\Users\\lluis\\Desktop\\errors.log";
    
    private Main() {}
    
    public static void main(String[] args) throws FileNotFoundException, Exception {
        Compiler compiler = new Compiler(INPUT_PATH, TOKENS_PATH, SYMBOL_TABLE_PATH, TREE_PATH, ERRORS_PATH);
        compiler.compile();
    }
}
