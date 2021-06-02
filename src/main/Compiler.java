package main;

import analyzers.LexicalAnalyzer;
import analyzers.SemanticAnalyzer;
import analyzers.SyntacticAnalyzer;
import assembly.x86.x86CodeGenerator;
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
    private final List<ProgramError> errorsList = new ArrayList<>();
    private SemanticAnalyzer semanticAnalyzer;

    public Compiler(String inputPath) throws FileNotFoundException {
        instance = this;
        this.scanner = new LexicalAnalyzer(inputPath);
        this.parser = new SyntacticAnalyzer(scanner);
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

    public void compile(Writer tokensWriter, Writer symbolTableWriter, Writer treeWriter, Writer tacWriter, Writer assemblyWriter, Writer errorsWriter) throws Exception {
        scanner.writeTokenList(tokensWriter);
        Program program = parser.getSyntaxTree();
        if (program != null) {
            semanticAnalyzer = new SemanticAnalyzer(program);
            semanticAnalyzer.validate();
            if (errorsList.isEmpty()) {
                semanticAnalyzer.writeSymbolTable(symbolTableWriter);
                semanticAnalyzer.writeSyntaxTree(treeWriter);
                semanticAnalyzer.writeTAC(tacWriter);
                x86CodeGenerator codeGenerator = new x86CodeGenerator(getSemanticAnalyzer().getSubprogramsTable(), getSemanticAnalyzer().getVariablesTable());
                semanticAnalyzer.writeAssembly(assemblyWriter, codeGenerator);
            }
        }
        writeErrors(errorsWriter);
    }

    private void writeErrors(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        StringBuilder buffer = new StringBuilder();
        for (ProgramError error : errorsList) {
            buffer.append(error.getMessage()).append("\n");
        }
        writer.write(buffer.toString());
        writer.close();
    }
}
