package main;

import dot.DotIdGenerator;
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
import parser.ParserSym;
import parser.symbols.Program;
import scanner.Scanner;
import symboltable.SymbolTable;

public final class Compiler {
    private static Compiler instance;
    
    private final String inputPath;
    private final Scanner scanner;
    private final Parser parser;
    private final PrintWriter tokensWriter, symbolTableWriter, treeWriter, errorsWriter;
    
    private Program program;
    private final SymbolTable symbolTable = new SymbolTable();
    private final List<ProgramError> errorsList = new ArrayList<>();
    private final DotIdGenerator dotIdGenerator = new DotIdGenerator();
    private final StringBuilder treeBuffer = new StringBuilder();
    
    public static Compiler getCompiler() {
        return instance;
    }

    public Compiler(String inputPath, String tokensPath, String symbolTablePath, String treePath, String errorsPath) throws FileNotFoundException {
        instance = this;
        SymbolFactory symbolFactory = new ComplexSymbolFactory();
        this.inputPath = inputPath;
        Reader input = new FileReader(inputPath);
        scanner = new Scanner(input);
        parser = new Parser(scanner, symbolFactory);
        tokensWriter = new PrintWriter(tokensPath);
        symbolTableWriter = new PrintWriter(symbolTablePath);
        treeWriter = new PrintWriter(treePath);
        errorsWriter = new PrintWriter(errorsPath);
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<ProgramError> getErrorsList() {
        return errorsList;
    }

    public DotIdGenerator getDotIdGenerator() {
        return dotIdGenerator;
    }

    public StringBuilder getTreeBuffer() {
        return treeBuffer;
    }

    public void compile() throws Exception {
        writeTokenList();
        Symbol parseResult = parser.parse();
        if (parseResult != null && parseResult.value instanceof Program) {
            program = (Program) parseResult.value; // Sintáctico
            program.validate(); // Semántico
            writeSymbolTable();
            writeTree();
        }
        writeErrors();
    }

    private void writeTokenList() throws IOException, LexicalError {
        StringBuilder buffer = new StringBuilder();
        Symbol tk = scanner.next_token();
        while (tk != null) {
            buffer.append(ParserSym.terminalNames[tk.sym]);
            buffer.append("\n");
            tk = scanner.next_token();
        }
        tokensWriter.print(buffer.toString());
        tokensWriter.close();
        scanner.yyreset(new FileReader(inputPath));
    }
    
    private void writeSymbolTable() {
        symbolTableWriter.write(symbolTable.toString());
        symbolTableWriter.close();
    }

    private void writeTree() {
        if (program == null) {
            return;
        }
        treeBuffer.append("strict digraph {\n");
        program.toDot();
        treeBuffer.append("}");
        treeWriter.write(treeBuffer.toString());
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
