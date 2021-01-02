package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

public final class Main {
    private static final String INPUT_PATH = "C:\\Users\\lluis\\Documents\\NetBeansProjects\\Compiladores2020\\src\\test_program.txt";
    
    private Main() {}
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            Compiler compiler = new Compiler(INPUT_PATH);
            List<Symbol> tokenList = compiler.getTokenList();
            for (Symbol token : tokenList) {
                System.out.print(token + " ");
            }
            compiler.parse();
        } catch (Exception ex) {
            System.out.println("Syntax error : " + ex.getMessage());
        }
    }
}
