package assembly.x86;

import assembly.AssemblyCodeGenerator;
import assembly.AssemblyLibrarySubprogram;
import assembly.x86.subprograms.*;
import tac.instructions.arithmetic.*;
import tac.instructions.array.NewArrayInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.instructions.bifurcation.ifs.specialtypes.IfDiffString;
import tac.instructions.bifurcation.ifs.specialtypes.IfEqualString;
import tac.instructions.binary.AndInstruction;
import tac.instructions.binary.NotInstruction;
import tac.instructions.binary.OrInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.instructions.io.ReadInstruction;
import tac.instructions.io.print.PrintArrayInstruction;
import tac.instructions.io.print.PrintBooleanInstruction;
import tac.instructions.io.print.PrintIntInstruction;
import tac.instructions.io.print.PrintStringInstruction;
import tac.instructions.length.StringLengthInstruction;
import tac.instructions.special.InitProgramInstruction;
import tac.instructions.subprogram.ComplexParameterInstruction;
import tac.instructions.subprogram.PreambleInstruction;
import tac.instructions.subprogram.SimpleParameterInstruction;
import tac.instructions.subprogram.calls.FunctionCallInstruction;
import tac.instructions.subprogram.calls.ProcedureCallInstruction;
import tac.instructions.subprogram.returns.FunctionReturnInstruction;
import tac.instructions.subprogram.returns.ProcedureReturnInstruction;
import tac.references.TACLiteral;
import tac.references.TACReference;
import tac.references.TACSubprogram;
import tac.references.TACVariable;
import tac.tables.SubprogramsTable;
import tac.tables.VariablesTable;

import java.util.*;

import static assembly.x86.AssemblyCodeGenerationConstants.STRING_BUFFER_BYTES;
import static assembly.x86.AssemblyCodeGenerationConstants.TRUE;

public class x86CodeGenerator implements AssemblyCodeGenerator {
    private final SubprogramsTable subprogramsTable;
    private final VariablesTable variablesTable;
    private final List<String> constantDeclarations = new ArrayList<>();
    private final Map<String, AssemblyLibrarySubprogram> subprograms = new HashMap<>();
    private boolean initialScope = true;

    public x86CodeGenerator(SubprogramsTable subprogramsTable, VariablesTable variablesTable) {
        this.variablesTable = variablesTable;
        this.subprogramsTable = subprogramsTable;
        constantDeclarations.add("decl_0: .asciz \"true\\n\"\n");
        constantDeclarations.add("decl_1: .asciz \"false\\n\"\n");
        constantDeclarations.add("decl_2: .quad 0\n"); // initial scope base pointer
        initSubprograms();
    }

    private void initSubprograms() {
        AssemblyLibrarySubprogram
                printInteger = new PrintIntegerSubprogram(),
                stringLength = new GetStringLengthSubprogram(),
                printString = new PrintStringSubprogram(Collections.singletonList(stringLength)),
                printBoolean = new PrintBooleanSubprogram(Collections.singletonList(printString)),
                readString = new ReadStringSubprogram(),
                compareStrings = new CompareStringsSubprogram(),
                allocateDynamicMemory = new AllocateDynamicMemory();
        printInteger.addToMap(subprograms);
        stringLength.addToMap(subprograms);
        printString.addToMap(subprograms);
        printBoolean.addToMap(subprograms);
        readString.addToMap(subprograms);
        compareStrings.addToMap(subprograms);
        allocateDynamicMemory.addToMap(subprograms);
    }

    @Override
    public String preamble() {
        StringBuilder preamble = new StringBuilder("""
                .section\t__TEXT, __text
                \t.globl\t_main
                """);
        for (AssemblyLibrarySubprogram subprogram : subprograms.values()) {
            preamble.append("\t.globl\t").append(subprogram.alias()).append("\n");
        }
        preamble.append(
                String.format("""
                                _main:
                                \tpush\t%%rbp
                                \tmov \t%%rsp, %%rbp
                                \tsubq\t$%s, %%rsp
                                \tmovq\tdecl_2@GOTPCREL(%%rip), %%rsi
                                \tmovq\t%%rbp, (%%rsi)
                                """,
                        variablesTable.getGlobalVariablesSize()
                )
        );
        return preamble.toString();
    }

    @Override
    public String epilogue() {
        StringBuilder epilogue = new StringBuilder();
        for (AssemblyLibrarySubprogram subprogram : subprograms.values()) {
            if (subprogram.isUsed()) {
                epilogue.append(subprogram.assemblyCode()).append("\n");
            }
        }
        epilogue.append(".section __DATA, __data\n");
        for (String declaration : constantDeclarations) {
            epilogue.append("\t").append(declaration);
        }
        return epilogue.toString();
    }

    @Override
    public String generate(InitProgramInstruction tacInstruction) {
        initialScope = false;
        return String.format("""
                            \tcall\t%s
                            \tmov \t$0x02000001, %%rax
                            \txor \t$0, %%rdi
                            \tsyscall
                            """,
                subprogramsTable.get("main").getTag()
        );
    }

    @Override
    public String generate(AddInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \taddq\t%%rbx, %%rax
                        %s
                         """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(CopyInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(DivideInstruction tacInstruction) {
        return String.format("""
                        %s
                        \tmovq\t%%rax, %%rdx
                        \tsarq\t$31, %%rdx
                        %s
                        \tidivq\t%%rbx
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ModuloInstruction tacInstruction) {
        return String.format("""
                        %s
                        \tmovq\t%%rax, %%rdx
                        \tsarq\t$31, %%rdx
                        %s
                        \tidivq\t%%rbx
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rdx", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(NegativeInstruction tacInstruction) {
        return String.format("""
                        \txorq \t%%rax, %%rax
                        %s
                        \tsubq\t%%rbx, %%rax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ProductInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \timulq\t%%rbx, %%rax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(SubtractInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \tsubq\t%%rbx, %%rax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(IfDiff tacInstruction) {
        return generateIfInstruction(tacInstruction, "je");
    }

    @Override
    public String generate(IfEqual tacInstruction) {
        return generateIfInstruction(tacInstruction, "jne");
    }

    @Override
    public String generate(IfGEQ tacInstruction) {
        return generateIfInstruction(tacInstruction, "jl");
    }

    @Override
    public String generate(IfGreater tacInstruction) {
        return generateIfInstruction(tacInstruction, "jle");
    }

    @Override
    public String generate(IfLEQ tacInstruction) {
        return generateIfInstruction(tacInstruction, "ja");
    }

    @Override
    public String generate(IfLess tacInstruction) {
        return generateIfInstruction(tacInstruction, "jge");
    }

    @Override
    public String generate(IfEqualString tacInstruction) {
        subprograms.get("compare_strings").setUsed();
        return String.format("""
                        %s
                        %s
                        \tcall \tcompare_strings
                        \tcmpq\t$%S, %%rdx
                        \tje  \t%s
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rsi"),
                loadInstruction(tacInstruction.getSecondReference(), "%rdi"),
                TRUE,
                tacInstruction.getThirdReference()
        );
    }

    @Override
    public String generate(IfDiffString tacInstruction) {
        subprograms.get("compare_strings").setUsed();
        return String.format("""
                        %s
                        %s
                        \tcall \tcompare_strings
                        \tcmpq\t$%s, %%rdx
                        \tjne \t%s
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rsi"),
                loadInstruction(tacInstruction.getSecondReference(), "%rdi"),
                TRUE,
                tacInstruction.getThirdReference()
        );
    }

    @Override
    public String generate(GotoInstruction tacInstruction) {
        return "\tjmp \t" + tacInstruction.getFirstReference() + "\n";
    }

    @Override
    public String generate(SkipInstruction tacInstruction) {
        return tacInstruction.getFirstReference() + ":\n";
    }

    @Override
    public String generate(AndInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \tandq\t%%rbx, %%rax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(NotInstruction tacInstruction) {
        return String.format("""
                        %s
                        \tnotq\t%%rbx
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rbx"),
                storeInstruction("%rbx", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(OrInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \torq \t%%rbx, %%rax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(IndexAssignmentInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \taddq\t%%rbx, %%rcx
                        %s
                        \tmovq\t%%rbx, (%%rcx)
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rcx"),
                loadInstruction(tacInstruction.getSecondReference(), "%rbx"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx")
        );
    }

    @Override
    public String generate(IndexedValueInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        \taddq\t%%rbx, %%rax
                        \tmovq\t(%%rax), %%rax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax"),
                loadInstruction(tacInstruction.getThirdReference(), "%rbx"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ProcedureCallInstruction tacInstruction) {
        SubprogramsTable.SubprogramInfo subprogramInfo = getSubprogramInfoOrThrowException(tacInstruction.getFirstReference());
        return String.format("""
                        \tcall\t%s
                        """,
                subprogramInfo.getTag()
        );
    }

    @Override
    public String generate(FunctionCallInstruction tacInstruction) {
        SubprogramsTable.SubprogramInfo subprogramInfo = getSubprogramInfoOrThrowException(tacInstruction.getSecondReference());
        return String.format("""
                        \tcall\t%s
                        %s
                        """,
                subprogramInfo.getTag(),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ComplexParameterInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(PreambleInstruction tacInstruction) {
        SubprogramsTable.SubprogramInfo subprogramInfo = getSubprogramInfoOrThrowException(tacInstruction.getFirstReference());
        return String.format("""
                        \tpush\t%%rbp
                        \tmov \t%%rsp, %%rbp
                        \tsubq\t$%s, %%rsp
                        """,
                subprogramInfo.getLocalVariablesSize()
        );
    }

    @Override
    public String generate(ProcedureReturnInstruction tacInstruction) {
        return """
                \tmovq\t%rbp, %rsp
                \tpop \t%rbp
                \tret
                                
                """;
    }

    @Override
    public String generate(FunctionReturnInstruction tacInstruction) {
        return String.format("""
                        %s
                        \tmovq\t%%rbp, %%rsp
                        \tpop \t%%rbp
                        \tret
                                        
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rax")
        );
    }

    @Override
    public String generate(SimpleParameterInstruction tacInstruction) {
        return String.format("""
                        %s
                        \tpush\t%%rax
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rax")
        );
    }

    @Override
    public String generate(ReadInstruction tacInstruction) {
        subprograms.get("dynalloc").setUsed();
        subprograms.get("read_string").setUsed();
        return String.format("""
                        \tpush\t$%s
                        \tcall\tdynalloc
                        \tmovq\t%%rax, %%rsi
                        \tcall\tread_string
                        %s
                        """,
                STRING_BUFFER_BYTES,
                storeInstruction("%rsi", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(PrintIntInstruction tacInstruction) {
        subprograms.get("print_uint64").setUsed();
        return String.format("""
                        %s
                        \tcall\tprint_uint64
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rdi")
        );
    }

    @Override
    public String generate(PrintBooleanInstruction tacInstruction) {
        subprograms.get("print_boolean").setUsed();
        return String.format("""
                        %s
                        \tcall\tprint_boolean
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rbx")
        );
    }

    @Override
    public String generate(PrintStringInstruction tacInstruction) {
        subprograms.get("print_string").setUsed();
        return String.format("""
                %s
                \tcall\tprint_string
                """, loadInstruction(tacInstruction.getFirstReference(), "%rsi"));
    }

    @Override
    public String generate(PrintArrayInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(StringLengthInstruction tacInstruction) {
        subprograms.get("string_length").setUsed();
        return String.format("""
                        %s
                        \tcall\tstring_length
                        \tsubq\t$1, %%rdx
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rsi"),
                storeInstruction("%rdx", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(NewArrayInstruction tacInstruction) {
        subprograms.get("dynalloc").setUsed();
        TACReference size = tacInstruction.getSecondReference();
        return String.format("""
                        %s
                        push\t%%rax
                        \tcall\tdynalloc
                        %s
                        """,
                loadInstruction(size, "%rax"),
                storeInstruction("%rax", tacInstruction.getFirstReference())
        );
    }

    private String loadInstruction(TACReference reference, String register) {
        if (reference instanceof TACLiteral) {
            if (((TACLiteral) reference).type().isString()) {
                String declarationName = "str_" + constantDeclarations.size();
                constantDeclarations.add(String.format("%s: .asciz %s\n", declarationName, reference));
                return String.format("\tmovq\t%s, %s", declarationName + "@GOTPCREL(%rip)", register);
            }
            return String.format("\tmovq\t$%s, %s", reference, register);
        }
        VariablesTable.VariableInfo variableInfo = getVariableInfoOrThrowException(reference);
        if (isLocalVariable(variableInfo) || initialScope) {
            return String.format("\tmovq\t%s(%%rbp), %s", variableInfo.getOffset(), register);
        } else if (isLocalArgument(variableInfo)) {
            return String.format("\tmovq\t%s(%%rbp), %s", variableInfo.getOffset() + 8, register);
        } else if (isGlobalVariable(variableInfo)) {
            return String.format("""
                    \tmovq\tdecl_2@GOTPCREL(%%rip), %%rsi
                    \tmovq\t(%%rsi), %%rsi
                    \tmovq\t%s(%%rsi), %s
                    """, variableInfo.getOffset(), register);
        } else {
            throw new RuntimeException("Unidentifiable variable");
        }
    }

    private String storeInstruction(String register, TACReference reference) {
        VariablesTable.VariableInfo variableInfo = getVariableInfoOrThrowException(reference);
        if (isLocalVariable(variableInfo) || initialScope) {
            return String.format("\tmovq\t%s, %s(%%rbp)", register, variableInfo.getOffset());
        } else if (isLocalArgument(variableInfo)) {
            return String.format("\tmovq\t%s, %s(%%rbp)", register, variableInfo.getOffset() + 8);
        } else if (isGlobalVariable(variableInfo)) {
            return String.format("""
                    \tmovq\tdecl_2@GOTPCREL(%%rip), %%rsi
                    \tmovq\t(%%rsi), %%rsi
                    \tmovq\t%s, %s(%%rsi)
                    """, register, variableInfo.getOffset());
        } else {
            throw new RuntimeException("Unidentifiable variable");
        }
    }

    private boolean isLocalVariable(VariablesTable.VariableInfo variableInfo) {
        return variableInfo.getScope().getIndentation() >= 1 && !variableInfo.isSubprogramArgument();
    }

    private boolean isLocalArgument(VariablesTable.VariableInfo variableInfo) {
        return variableInfo.getScope().getIndentation() >= 1 && variableInfo.isSubprogramArgument();
    }

    private boolean isGlobalVariable(VariablesTable.VariableInfo variableInfo) {
        return variableInfo.getScope().getIndentation() < 1 && !variableInfo.isSubprogramArgument();
    }

    private VariablesTable.VariableInfo getVariableInfoOrThrowException(TACReference reference) {
        if (!(reference instanceof TACVariable)) {
            throw new RuntimeException(reference + " is not a TACVariable");
        }
        VariablesTable.VariableInfo variableInfo = variablesTable.get((TACVariable) reference);
        if (variableInfo == null) {
            throw new RuntimeException("Variable not stored in variables table");
        }
        return variableInfo;
    }

    private SubprogramsTable.SubprogramInfo getSubprogramInfoOrThrowException(TACReference reference) {
        if (!(reference instanceof TACSubprogram)) {
            throw new RuntimeException(reference + " is not a TACSubprogram");
        }
        SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get((TACSubprogram) reference);
        if (subprogramInfo == null) {
            throw new RuntimeException("Subprogram not stored in subprograms table");
        }
        return subprogramInfo;
    }

    private String generateIfInstruction(IfInstruction tacInstruction, String comparisonCode) {
        return String.format("""
                        %s
                        %s
                        \tcmpq\t%%rbx, %%rax
                        \t%s \t1f
                        \tjmp\t%s
                        1:
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rax"),
                loadInstruction(tacInstruction.getSecondReference(), "%rbx"),
                comparisonCode,
                tacInstruction.getThirdReference()
        );
    }
}
