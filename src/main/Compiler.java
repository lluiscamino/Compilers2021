package main;

import errors.LexicalError;
import errors.ProgramError;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import parser.Parser;
import parser.symbols.Program;
import scanner.Scanner;
import symboltable.SymbolTable;

public final class Compiler {
    
    public static final List<ProgramError> errorsList = new ArrayList<>();

    private final String inputPath;
    private final Scanner scanner;
    private final Parser parser;
    private final PrintWriter tokensWriter, treeWriter, errorsWriter;
    private Program program;

    public Compiler(String inputPath, String tokensPath, String treePath, String errorsPath) throws FileNotFoundException {
        SymbolFactory symbolFactory = new ComplexSymbolFactory();
        this.inputPath = inputPath;
        Reader input = new FileReader(inputPath);
        scanner = new Scanner(input);
        parser = new Parser(scanner, symbolFactory);
        tokensWriter = new PrintWriter(tokensPath);
        treeWriter = new PrintWriter(treePath);
        errorsWriter = new PrintWriter(errorsPath);
    }

    public void compile() throws Exception {
        writeTokenList();
        program = (Program) parser.parse().value; // Sintáctico
        writeTree();
        program.validate(new SymbolTable()); // Semántico
        writeErrors();
    }

    private void writeTokenList() throws IOException, LexicalError {
        StringBuilder buffer = new StringBuilder();
        Symbol tk = scanner.next_token();
        while (tk != null) {
            buffer.append(tk.toString().substring(8));
            buffer.append("\n");
            tk = scanner.next_token();
        }
        tokensWriter.print(buffer.toString());
        tokensWriter.close();
        scanner.yyreset(new FileReader(inputPath));
    }

    private void writeTree() {
        if (program == null) {
            return;
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("strict digraph {\n");
        program.toDot(buffer);
        buffer.append("}");
        treeWriter.write(buffer.toString());
        treeWriter.close();
    }

    private void writeErrors() {
        StringBuilder buffer = new StringBuilder();
        for (ProgramError error : errorsList) {
            buffer.append(error.getMessage()).append("\n");
        }
        errorsWriter.write(buffer.toString());
        errorsWriter.close();
    }
}
