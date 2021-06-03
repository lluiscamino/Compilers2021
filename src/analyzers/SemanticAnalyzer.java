package analyzers;

import assembly.AssemblyCodeGenerator;
import assembly.x86.SizeOffsetCalculator;
import dot.DotIdGenerator;
import optimizers.*;
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
    private List<TACInstruction> tacInstructionList;
    private final SubprogramsTable subprogramsTable;
    private final VariablesTable variablesTable;

    private final StringBuilder treeBuffer;

    public SemanticAnalyzer(Program program) {
        this.program = program;
        this.symbolTable = new SymbolTable();
        this.dotIdGenerator = new DotIdGenerator();
        this.tacVariableGenerator = new TACVariableGenerator();
        this.tacSubprogramGenerator = new TACSubprogramGenerator();
        this.tacTagGenerator = new TACTagGenerator();
        this.tacInstructionList = new ArrayList<>();
        this.subprogramsTable = new SubprogramsTable();
        this.variablesTable = new VariablesTable();
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

    public void writeSymbolTable(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        writer.write(symbolTable.toString());
        writer.close();
    }

    public void writeSyntaxTree(Writer writer) throws IOException {
        if (program == null || writer == null) {
            return;
        }
        treeBuffer.append("strict digraph {\n");
        program.toDot();
        treeBuffer.append("}");
        writer.write(treeBuffer.toString());
        writer.close();
    }

    public void generateTAC() {
        symbolTable.clear();
        program.toTac();
    }

    public void optimizeTACInstructionList() {
        tacInstructionList = new NeedlessGotosOptimizer(new InaccessibleCodeOptimizer(new UnusedTagsOptimizer(new ConstantIfsOptimizer(new ConstantOperationsOptimizer(new DifferedAssignmentsOptimizer(new AdjacentBranchesOptimizer(tacInstructionList).optimize()).optimize()).optimize()).optimize(), subprogramsTable).optimize()).optimize()).optimize();
        removeUnusedVariables();
    }

    private void removeUnusedVariables() {
        new UnusedTACVariablesRemover(tacInstructionList, variablesTable).removeUnusedVariables();
    }

    public void writeTAC(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        StringBuilder tacBuffer = new StringBuilder();
        for (TACInstruction tacInstruction : tacInstructionList) {
            tacBuffer.append(tacInstruction).append("\n");
        }
        writer.write(tacBuffer.toString());
        writer.close();
    }

    public void writeVariablesTable(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        writer.write(variablesTable.toString());
        writer.close();
    }

    public void writeSubprogramsTable(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        writer.write(subprogramsTable.toString());
        writer.close();
    }

    public void writeAssembly(Writer writer, AssemblyCodeGenerator codeGenerator) throws IOException {
        if (writer == null) {
            return;
        }
        calculateSizesAndOffsets();
        StringBuilder assemblyBuffer = buildAssemblyBuffer(codeGenerator);
        writer.write(assemblyBuffer.toString());
        writer.close();
    }

    private void calculateSizesAndOffsets() {
        new SizeOffsetCalculator().calculate(subprogramsTable, variablesTable);
    }

    private StringBuilder buildAssemblyBuffer(AssemblyCodeGenerator codeGenerator) {
        StringBuilder assemblyBuffer = new StringBuilder();
        assemblyBuffer.append(codeGenerator.preamble());
        for (TACInstruction instruction : tacInstructionList) {
            assemblyBuffer.append("/*").append(instruction).append("*/\n");
            String asm = instruction.toAssemblyCode(codeGenerator);
            assemblyBuffer.append(asm != null ? asm : "/*null*/\n");
        }
        assemblyBuffer.append(codeGenerator.epilogue());
        return assemblyBuffer;
    }
}
