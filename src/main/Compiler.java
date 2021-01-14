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
import parser.ParserSym;
import parser.symbols.Program;
import scanner.Scanner;
import symboltable.SymbolTable;

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
    
    public void writeTokenList(String outputPath) throws IOException, LexicalError {
        PrintWriter out = new PrintWriter(outputPath);
        StringBuilder buffer = new StringBuilder();
        Symbol tk = scanner.next_token();
        while (tk != null) {
            buffer.append(tk.toString().substring(8));
            /*if (tk.sym == ParserSym.EOL) {
                buffer.append("\n");
            } else {
                buffer.append(" ");
            }*/
            buffer.append("\n");
            tk = scanner.next_token();
        }
        out.print(buffer.toString());
        out.close();
        scanner.yyreset(new FileReader(inputPath));
    }
    
    public void toDot(String outputPath) throws Exception {
        if (program == null) {
            throw new Exception("Parse file first to get .dot file");
        }
        PrintWriter out = new PrintWriter(outputPath);
        StringBuilder buffer = new StringBuilder();
        buffer.append("strict digraph {\n");
        program.toDot(buffer);
        buffer.append("}");
        out.write(buffer.toString());
        out.close();
    }
    
    public void parse() throws Exception {
        program = (Program) parser.parse().value; // Sintáctico
        program.validate(new SymbolTable()); // Semántico
    }
}
