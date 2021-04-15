package main;

import analyzers.LexicalAnalyzer;
import analyzers.SemanticAnalyzer;
import analyzers.SyntacticAnalyzer;
import errors.ProgramError;
import parser.symbols.Program;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class Compiler {
    private static Compiler instance;

    private final LexicalAnalyzer scanner;
    private final SyntacticAnalyzer parser;
    private final Writer symbolTableWriter, treeWriter, errorsWriter;
    private final List<ProgramError> errorsList = new ArrayList<>();
    private SemanticAnalyzer semanticAnalyzer;

    public Compiler(String inputPath, Writer tokensWriter, Writer symbolTableWriter, Writer treeWriter, Writer errorsWriter) throws FileNotFoundException {
        instance = this;
        this.scanner = new LexicalAnalyzer(inputPath, tokensWriter);
        this.parser = new SyntacticAnalyzer(scanner);
        this.symbolTableWriter = symbolTableWriter;
        this.treeWriter = treeWriter;
        this.errorsWriter = errorsWriter;
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
            semanticAnalyzer = new SemanticAnalyzer(program, symbolTableWriter, treeWriter);
            semanticAnalyzer.validate();
            semanticAnalyzer.writeSymbolTable();
            semanticAnalyzer.writeTree();
            semanticAnalyzer.generateTAC();
        }
        writeErrors();
    }

    private void writeErrors() throws IOException {
        StringBuilder buffer = new StringBuilder();
        for (ProgramError error : errorsList) {
            buffer.append(error.getMessage()).append("\n");
        }
        errorsWriter.write(buffer.toString());
        errorsWriter.close();
    }
}
