package main;

import java.io.FileNotFoundException;
import java.util.List;
import java_cup.runtime.Symbol;

public final class Main {
    private static final String INPUT_PATH = "C:\\Users\\lluis\\Desktop\\programa.txt";
    
    private Main() {}
    
    public static void main(String[] args) throws FileNotFoundException, Exception {
        Compiler compiler = new Compiler(INPUT_PATH);
        List<Symbol> tokenList = compiler.getTokenList();
        for (Symbol token : tokenList) {
            System.out.print(token + " ");
        }
        compiler.parse();
    }
}
