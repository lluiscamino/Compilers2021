package analyzers;

import dot.DotIdGenerator;
import parser.symbols.Program;
import symboltable.SymbolTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

public final class SemanticAnalyzer {
    private final Program program;
    private final SymbolTable symbolTable;
    private final DotIdGenerator dotIdGenerator;
    private final Writer symbolTableWriter, treeWriter;
    private final StringBuilder treeBuffer;

    public SemanticAnalyzer(Program program, Writer symbolTableWriter, Writer treeWriter) {
        this.program = program;
        this.symbolTable = new SymbolTable();
        this.dotIdGenerator = new DotIdGenerator();
        this.symbolTableWriter = symbolTableWriter;
        this.treeWriter = treeWriter;
        this.treeBuffer = new StringBuilder();
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public DotIdGenerator getDotIdGenerator() {
        return dotIdGenerator;
    }

    public StringBuilder getTreeBuffer() {
        return treeBuffer;
    }

    public void validate() {
        program.validate();
    }

    public void writeSymbolTable() throws IOException {
        symbolTableWriter.write(symbolTable.toString());
        symbolTableWriter.close();
    }

    public void writeTree() throws IOException {
        if (program == null) {
            return;
        }
        treeBuffer.append("strict digraph {\n");
        program.toDot();
        treeBuffer.append("}");
        treeWriter.write(treeBuffer.toString());
        treeWriter.close();
    }
}
