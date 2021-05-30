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
    private final Writer symbolTableWriter, treeWriter, tacWriter, assemblyWriter;
    private final StringBuilder treeBuffer;

    public SemanticAnalyzer(Program program, Writer symbolTableWriter, Writer treeWriter, Writer tacWriter, Writer assemblyWriter) {
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
        this.tacWriter = tacWriter;
        this.assemblyWriter = assemblyWriter;
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

    public void generateTAC() throws IOException {
        symbolTable.clear();
        program.toTac();
        StringBuilder tacBuffer = new StringBuilder();
        for (TACInstruction tacInstruction : tacInstructionList) {
            tacBuffer.append(tacInstruction).append("\n");
        }
        tacWriter.write(tacBuffer.toString());
        tacWriter.close();
    }

    public void generateAssembly() throws IOException {
        StringBuilder assemblyBuffer = new StringBuilder();
        List<TACInstruction> tacInstructions = Compiler.getCompiler().getSemanticAnalyzer().getTacInstructionList();
        List<TACInstruction> optimizedInstructions =
                new NeedlessGotosOptimizer(new InaccessibleCodeOptimizer(new UnusedTagsOptimizer(new ConstantIfsOptimizer(new ConstantOperationsOptimizer(new DifferedAssignmentsOptimizer(new AdjacentBranchesOptimizer(tacInstructions).optimize()).optimize()).optimize()).optimize(), subprogramsTable).optimize()).optimize()).optimize();
        new UnusedTACVariablesRemover(optimizedInstructions, Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable()).removeUnusedVariables();
        new SizeOffsetCalculator().calculate(subprogramsTable, variablesTable);
        AssemblyCodeGenerator codeGenerator = new x86CodeGenerator(subprogramsTable, variablesTable);
        assemblyBuffer.append(codeGenerator.preamble());
        for (TACInstruction instruction : optimizedInstructions) {
            assemblyBuffer.append("/*").append(instruction).append("*/\n");
            String asm = instruction.toAssemblyCode(codeGenerator);
            assemblyBuffer.append(asm != null ? asm : "/*null*/\n");
        }
        assemblyBuffer.append(codeGenerator.epilogue());
        assemblyWriter.write(assemblyBuffer.toString());
        assemblyWriter.close();
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
