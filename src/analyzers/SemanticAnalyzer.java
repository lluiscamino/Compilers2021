package analyzers;

import dot.DotIdGenerator;
import parser.symbols.Program;
import symboltable.SymbolTable;
import tac.generators.TACSubprogramGenerator;
import tac.generators.TACTagGenerator;
import tac.generators.TACVariableGenerator;
import tac.instructions.TACInstruction;
import tac.tables.SubprogramsTable;
import tac.tables.VariablesTable;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class SemanticAnalyzer {
    private final Program program;
    private final SymbolTable symbolTable;
    private final DotIdGenerator dotIdGenerator;
    private final TACVariableGenerator tacVariableGenerator;
    private final TACSubprogramGenerator tacSubprogramGenerator;
    private final TACTagGenerator tacTagGenerator;
    private final List<TACInstruction> tacInstructionList;
    private final SubprogramsTable subprogramsTable;
    private final VariablesTable variablesTable;
    private final Writer symbolTableWriter, treeWriter;
    private final StringBuilder treeBuffer;

    public SemanticAnalyzer(Program program, Writer symbolTableWriter, Writer treeWriter) {
        this.program = program;
        this.symbolTable = new SymbolTable();
        this.dotIdGenerator = new DotIdGenerator();
        this.tacVariableGenerator = new TACVariableGenerator();
        this.tacSubprogramGenerator = new TACSubprogramGenerator();
        this.tacTagGenerator = new TACTagGenerator();
        this.tacInstructionList = new ArrayList<>();
        this.subprogramsTable = new SubprogramsTable();
        this.variablesTable = new VariablesTable();
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

    public TACVariableGenerator getTacVariableGenerator() {
        return tacVariableGenerator;
    }

    public TACSubprogramGenerator getTacSubprogramGenerator() {
        return tacSubprogramGenerator;
    }

    public TACTagGenerator getTacTagGenerator() {
        return tacTagGenerator;
    }

    public List<TACInstruction> getTacInstructionList() {
        return tacInstructionList;
    }

    public SubprogramsTable getSubprogramsTable() {
        return subprogramsTable;
    }

    public VariablesTable getVariablesTable() {
        return variablesTable;
    }

    public StringBuilder getTreeBuffer() {
        return treeBuffer;
    }

    public void validate() {
        program.validate();
    }

    public void generateTAC() {
        symbolTable.clear();
        program.toTac();
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
