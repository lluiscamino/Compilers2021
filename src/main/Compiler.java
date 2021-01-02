package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import parser.Parser;
import scanner.Scanner;

public final class Compiler {
    private final String inputPath;
    private final Scanner scanner;
    private final Parser parser;
    
    public Compiler(String inputPath) throws FileNotFoundException {
        SymbolFactory symbolFactory = new ComplexSymbolFactory();
        this.inputPath = inputPath;
        Reader input = new FileReader(inputPath);
        scanner = new Scanner(input);
        parser = new Parser(scanner, symbolFactory);
    }
    
    public List<Symbol> getTokenList() throws IOException {
        List<Symbol> tokenList = new LinkedList<>();
        Symbol tk = scanner.next_token();
        while (tk != null) {
            System.out.println(tk);
            tk = scanner.next_token();
        }
        scanner.yyreset(new FileReader(inputPath));
        return tokenList;
    }
    
    public void parse() throws Exception {
        parser.parse();
    }
}
