package main;

import analyzers.LexicalAnalyzer;
import analyzers.SemanticAnalyzer;
import analyzers.SyntacticAnalyzer;
import errors.ProgramError;
import parser.symbols.Program;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public final class Compiler {
    private static Compiler instance;

    private final LexicalAnalyzer scanner;
    private final SyntacticAnalyzer parser;
    private final String symbolTablePath, treePath;
    private final PrintWriter errorsWriter;
    private final List<ProgramError> errorsList = new ArrayList<>();
    private SemanticAnalyzer semanticAnalyzer;

    public Compiler(String inputPath, String tokensPath, String symbolTablePath, String treePath, String errorsPath) throws FileNotFoundException {
        instance = this;
        this.scanner = new LexicalAnalyzer(inputPath, tokensPath);
        this.parser = new SyntacticAnalyzer(scanner);
        this.symbolTablePath = symbolTablePath;
        this.treePath = treePath;
        this.errorsWriter = new PrintWriter(errorsPath);
    }

    public static Compiler getCompiler() {
        return instance;
    }

    public SyntacticAnalyzer getParser() {
        return parser;
    }

    public SemanticAnalyzer getSemanticAnalyzer() {
        return semanticAnalyzer;
    }

    public List<ProgramError> getErrorsList() {
        return errorsList;
    }

    public void compile() throws Exception {
        scanner.writeTokenList();
        Program program = parser.getSyntaxTree();
        if (program != null) {
            semanticAnalyzer = new SemanticAnalyzer(program, symbolTablePath, treePath);
            semanticAnalyzer.validate();
            semanticAnalyzer.writeSymbolTable();
            semanticAnalyzer.writeTree();
        }
        writeErrors();
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
