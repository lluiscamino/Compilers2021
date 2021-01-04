package main;

import exceptions.LexicalError;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import parser.Parser;
import parser.symbols.Program;
import scanner.Scanner;

public final class Compiler {
    private final String inputPath;
    private final Scanner scanner;
    private final Parser parser;
    private Program program;
    
    public Compiler(String inputPath) throws FileNotFoundException {
        SymbolFactory symbolFactory = new ComplexSymbolFactory();
        this.inputPath = inputPath;
        Reader input = new FileReader(inputPath);
        scanner = new Scanner(input);
        parser = new Parser(scanner, symbolFactory);
    }
    
    public List<Symbol> getTokenList() throws IOException, LexicalError {
        List<Symbol> tokenList = new LinkedList<>();
        Symbol tk = scanner.next_token();
        while (tk != null) {
            System.out.println(tk);
            tk = scanner.next_token();
        }
        scanner.yyreset(new FileReader(inputPath));
        return tokenList;
    }
    
    public void toDot(String outputPath) throws Exception {
        if (program == null) {
            throw new Exception("Parse file first to get .dot file");
        }
        PrintWriter out = new PrintWriter(outputPath);
        out.println("strict digraph {");
        program.toDot(out);
        out.println("}");
        out.close();
    }
    
    public void parse() throws Exception {
        program = (Program) parser.parse().value;
    }
}
