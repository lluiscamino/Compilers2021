package analyzers;

import assembly.AssemblyCodeGenerator;
import assembly.x86.SizeOffsetCalculator;
import assembly.x86.x86CodeGenerator;
import dot.DotIdGenerator;
import main.Compiler;
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
    private final List<TACInstruction> tacInstructionList;
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

    public void writeTAC(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        symbolTable.clear();
        program.toTac();
        StringBuilder tacBuffer = new StringBuilder();
        for (TACInstruction tacInstruction : tacInstructionList) {
            tacBuffer.append(tacInstruction).append("\n");
        }
        writer.write(tacBuffer.toString());
        writer.close();
    }

    public void writeAssembly(Writer writer, AssemblyCodeGenerator codeGenerator) throws IOException {
        if (writer == null) {
            return;
        }
        List<TACInstruction> optimizedInstructions = optimizeTACInstructions();
        removeUnusedVariables(optimizedInstructions);
        calculateSizesAndOffsets();
        StringBuilder assemblyBuffer = buildAssemblyBuffer(optimizedInstructions, codeGenerator);
        writer.write(assemblyBuffer.toString());
        writer.close();
    }

    private List<TACInstruction> optimizeTACInstructions() {
        return new NeedlessGotosOptimizer(new InaccessibleCodeOptimizer(new UnusedTagsOptimizer(new ConstantIfsOptimizer(new ConstantOperationsOptimizer(new DifferedAssignmentsOptimizer(new AdjacentBranchesOptimizer(tacInstructionList).optimize()).optimize()).optimize()).optimize(), subprogramsTable).optimize()).optimize()).optimize();
    }

    private void removeUnusedVariables(List<TACInstruction> optimizedTACInstructions) {
        new UnusedTACVariablesRemover(optimizedTACInstructions, variablesTable).removeUnusedVariables();
    }

    private void calculateSizesAndOffsets() {
        new SizeOffsetCalculator().calculate(subprogramsTable, variablesTable);
    }

    private StringBuilder buildAssemblyBuffer(List<TACInstruction> optimizedTACInstructions, AssemblyCodeGenerator codeGenerator) {
        StringBuilder assemblyBuffer = new StringBuilder();
        assemblyBuffer.append(codeGenerator.preamble());
        for (TACInstruction instruction : optimizedTACInstructions) {
            assemblyBuffer.append("/*").append(instruction).append("*/\n");
            String asm = instruction.toAssemblyCode(codeGenerator);
            assemblyBuffer.append(asm != null ? asm : "/*null*/\n");
        }
        assemblyBuffer.append(codeGenerator.epilogue());
        return assemblyBuffer;
    }
}
