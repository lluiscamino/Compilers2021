package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java_cup.runtime.Symbol;

public final class Main {
    private static final String INPUT_PATH = "C:\\Users\\lluis\\Documents\\NetBeansProjects\\Compiladores2020\\src\\test_program1.txt";
    
    private Main() {}
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        
            Compiler compiler = new Compiler(INPUT_PATH);
            /*List<Symbol> tokenList = compiler.getTokenList();
            for (Symbol token : tokenList) {
                System.out.print(token + " ");
            }*/
            compiler.parse();
        
    }
}
