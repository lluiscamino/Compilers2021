package assembly.x86;

import assembly.AssemblyCodeGenerator;
import assembly.AssemblyLibrarySubprogram;
import assembly.x86.registers.x86RegisterFactory;
import assembly.x86.subprograms.*;
import parser.symbols.types.Type;
import tac.instructions.arithmetic.*;
import tac.instructions.array.NewDynamicArrayInstruction;
import tac.instructions.array.NewStaticArrayInstruction;
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
import tac.instructions.subprogram.ParameterInstruction;
import tac.instructions.subprogram.PreambleInstruction;
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

import static assembly.x86.AssemblyCodeGenerationConstants.*;

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
                compareStrings = new CompareStringsSubprogram();
        printInteger.addToMap(subprograms);
        stringLength.addToMap(subprograms);
        printString.addToMap(subprograms);
        printBoolean.addToMap(subprograms);
        readString.addToMap(subprograms);
        compareStrings.addToMap(subprograms);
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
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        %s
                         """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("add", size), bRegister, aRegister,
                storeInstruction("%rax", tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(CopyInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size);
        return String.format("""
                        %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(DivideInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size),
                bRegister = register("b", size),
                dRegister = register("d", size);
        return String.format("""
                        %s
                        \t%s\t%s, %s
                        \t%s\t$31, %s
                        %s
                        \t%s\t%s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                instructionCode("mov", size), aRegister, dRegister,
                instructionCode("sar", size), dRegister,
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("idiv", size), bRegister,
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(ModuloInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size),
                bRegister = register("b", size),
                dRegister = register("d", size);
        return String.format("""
                        %s
                        \t%s\t%s, %s
                        \t%s\t$31, %s
                        %s
                        \t%s\t%s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                instructionCode("mov", size), aRegister, dRegister,
                instructionCode("sar", size), dRegister,
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("idiv", size), bRegister,
                storeInstruction(dRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(NegativeInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        \t%s \t%s, %s
                        %s
                        \t%s\t%s, %s
                        %s
                        """,
                instructionCode("xor", size), aRegister, aRegister,
                loadInstruction(tacInstruction.getSecondReference(), bRegister, size),
                instructionCode("sub", size), bRegister, aRegister,
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(ProductInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("imul", size), bRegister, aRegister,
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(SubtractInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("sub", size), bRegister, aRegister,
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
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

    private String generateIfInstruction(IfInstruction tacInstruction, String comparisonCode) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        \t%s \t1f
                        \tjmp\t%s
                        1:
                        """,
                loadInstruction(tacInstruction.getFirstReference(), aRegister, size),
                loadInstruction(tacInstruction.getSecondReference(), bRegister, size),
                instructionCode("cmp", size), bRegister, aRegister,
                comparisonCode,
                tacInstruction.getThirdReference()
        );
    }

    @Override
    public String generate(IfEqualString tacInstruction) {
        subprograms.get("compare_strings").setUsed();
        return String.format("""
                        %s
                        %s
                        \tcall \tcompare_strings
                        \t%s\t$%s, %s
                        \tje  \t%s
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rsi", Type.getInteger().sizeInBytes()),
                loadInstruction(tacInstruction.getSecondReference(), "%rdi", Type.getInteger().sizeInBytes()),
                instructionCode("cmp", Type.getBoolean().sizeInBytes()), TRUE, register("d", Type.getBoolean().sizeInBytes()),
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
                        \t%s\t$%s, %s
                        \tjne \t%s
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rsi", Type.getInteger().sizeInBytes()),
                loadInstruction(tacInstruction.getSecondReference(), "%rdi", Type.getInteger().sizeInBytes()),
                instructionCode("cmp", Type.getBoolean().sizeInBytes()), TRUE, register("d", Type.getBoolean().sizeInBytes()),
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
        int size = Type.getBoolean().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("and", size), bRegister, aRegister,
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(NotInstruction tacInstruction) {
        int size = Type.getBoolean().sizeInBytes();
        String bRegister = register("b", size);
        return String.format("""
                        %s
                        \t%s\t%s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), bRegister, size),
                instructionCode("not", size), bRegister,
                storeInstruction(bRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(OrInstruction tacInstruction) {
        int size = Type.getBoolean().sizeInBytes();
        String aRegister = register("a", size), bRegister = register("b", size);
        return String.format("""
                        %s
                        %s
                        \t%s \t%s, %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size),
                loadInstruction(tacInstruction.getThirdReference(), bRegister, size),
                instructionCode("or", size), bRegister, aRegister,
                storeInstruction(aRegister, tacInstruction.getFirstReference(), size)
        );
    }

    @Override
    public String generate(IndexAssignmentInstruction tacInstruction) {
        int addressSize = Type.getInteger().sizeInBytes();
        int valueSize = tacInstruction.getThirdReference().sizeInBytes();
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        %s
                        \t%s\t%s, (%s)
                        """,
                loadInstruction(tacInstruction.getFirstReference(), register("c", addressSize), addressSize),
                loadInstruction(tacInstruction.getSecondReference(), register("b", addressSize), addressSize),
                instructionCode("add", addressSize), register("b", addressSize), register("c", addressSize),
                loadInstruction(tacInstruction.getThirdReference(), register("b", valueSize), valueSize),
                instructionCode("mov", valueSize), register("b", valueSize), register("c", addressSize)
        );
    }

    @Override
    public String generate(IndexedValueInstruction tacInstruction) {
        int addressSize = Type.getInteger().sizeInBytes();
        int valueSize = tacInstruction.getFirstReference().sizeInBytes();
        return String.format("""
                        %s
                        %s
                        \t%s\t%s, %s
                        \t%s\t(%s), %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), register("a", addressSize), addressSize),
                loadInstruction(tacInstruction.getThirdReference(), register("b", addressSize), addressSize),
                instructionCode("add", addressSize), register("b", addressSize), register("a", addressSize),
                instructionCode("mov", valueSize), register("a", addressSize), register("a", valueSize),
                storeInstruction(register("a", valueSize), tacInstruction.getFirstReference(), valueSize)
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
        int size = tacInstruction.getFirstReference().sizeInBytes();
        SubprogramsTable.SubprogramInfo subprogramInfo = getSubprogramInfoOrThrowException(tacInstruction.getSecondReference());
        return String.format("""
                        \tcall\t%s
                        %s
                        """,
                subprogramInfo.getTag(),
                storeInstruction(register("a", size), tacInstruction.getFirstReference(), size)
        );
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
        int size = tacInstruction.getSecondReference().sizeInBytes();
        String aRegister = register("a", size);
        return String.format("""
                        %s
                        \tmovq\t%%rbp, %%rsp
                        \tpop \t%%rbp
                        \tret
                                        
                        """,
                loadInstruction(tacInstruction.getSecondReference(), aRegister, size)
        );
    }

    @Override
    public String generate(ParameterInstruction tacInstruction) {
        String aRegister = register("a", PUSH_DEFAULT_BYTES);
        return String.format("""
                        %s
                        \tpush\t%s
                        """,
                loadInstruction(tacInstruction.getFirstReference(), aRegister, PUSH_DEFAULT_BYTES),
                aRegister
        );
    }

    @Override
    public String generate(ReadInstruction tacInstruction) {
        subprograms.get("read_string").setUsed();
        return String.format("""
                        \tmovq\t$%s, %%rdi
                        \tmovq\t%%rsp, %%rbx
                        \tand \t$-16, %%rsp
                        \tcall\t_malloc
                        \tmovq\t%%rbx, %%rsp
                        \tmovq\t%%rax, %%rsi
                        \tcall\tread_string
                        %s
                        """,
                STRING_BUFFER_BYTES,
                storeInstruction("%rsi", tacInstruction.getFirstReference(), Type.getInteger().sizeInBytes())
        );
    }

    @Override
    public String generate(PrintIntInstruction tacInstruction) {
        subprograms.get("print_uint64").setUsed();
        return String.format("""
                        %s
                        \tcall\tprint_uint64
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%rdi", Type.getInteger().sizeInBytes())
        );
    }

    @Override
    public String generate(PrintBooleanInstruction tacInstruction) {
        int size = Type.getBoolean().sizeInBytes();
        subprograms.get("print_boolean").setUsed();
        return String.format("""
                        %s
                        \tcall\tprint_boolean
                        """,
                loadInstruction(tacInstruction.getFirstReference(), register("b", size), size)
        );
    }

    @Override
    public String generate(PrintStringInstruction tacInstruction) {
        subprograms.get("print_string").setUsed();
        return String.format("""
                %s
                \tcall\tprint_string
                """, loadInstruction(tacInstruction.getFirstReference(), "%rsi", Type.getInteger().sizeInBytes())
        );
    }

    @Override
    public String generate(PrintArrayInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(StringLengthInstruction tacInstruction) {
        int size = tacInstruction.getFirstReference().sizeInBytes();
        String dRegister = register("d", size);
        subprograms.get("string_length").setUsed();
        return String.format("""
                        %s
                        \tcall\tstring_length
                        \t%s\t$1, %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%rsi", size),
                instructionCode("sub", size), dRegister,
                storeInstruction(dRegister, tacInstruction.getFirstReference(), Type.getInteger().sizeInBytes())
        );
    }

    @Override
    public String generate(NewStaticArrayInstruction tacInstruction) {
        String declarationName = "arr_" + constantDeclarations.size();
        constantDeclarations.add(String.format("%s: .fill %s, 1\n", declarationName, tacInstruction.getSizeInBytes()));
        return String.format("""
                        \tmovq\t%s, %%rax
                        %s
                        """,
                declarationName + "@GOTPCREL(%rip)",
                storeInstruction("%rax", tacInstruction.getFirstReference(), Type.getInteger().sizeInBytes())
        );
    }

    @Override
    public String generate(NewDynamicArrayInstruction tacInstruction) {
        return String.format("""
                        \tmovq\t%%rsp, %%rbx
                        \tand \t$-16, %%rsp
                        %s
                        \tcall\t_malloc
                        \tmovq\t%%rbx, %%rsp
                        %s
                        """,
                loadInstruction(tacInstruction.getSize(), "%rdi", Type.getInteger().sizeInBytes()),
                storeInstruction("%rax", tacInstruction.getFirstReference(), Type.getInteger().sizeInBytes())
        );
    }

    private String loadInstruction(TACReference reference, String register, int size) {
        if (reference instanceof TACLiteral) {
            if (((TACLiteral) reference).type().isString()) {
                String declarationName = "str_" + constantDeclarations.size();
                constantDeclarations.add(String.format("%s: .asciz %s\n", declarationName, reference));
                return String.format("\tmovq\t%s, %s", declarationName + "@GOTPCREL(%rip)", register);
            }
            return String.format("\t%s\t$%s, %s", instructionCode("mov", size), reference, register);
        }
        VariablesTable.VariableInfo variableInfo = getVariableInfoOrThrowException(reference);
        if (isLocalVariable(variableInfo) || initialScope) {
            return String.format("\t%s\t%s(%%rbp), %s", instructionCode("mov", size), variableInfo.getOffset(), register);
        } else if (isLocalArgument(variableInfo)) {
            return String.format("\t%s\t%s(%%rbp), %s", instructionCode("mov", size), variableInfo.getOffset() + 8, register);
        } else if (isGlobalVariable(variableInfo)) {
            return String.format("""
                    \tmovq\tdecl_2@GOTPCREL(%%rip), %%rsi
                    \tmovq\t(%%rsi), %%rsi
                    \t%s\t%s(%%rsi), %s
                    """, instructionCode("mov", size), variableInfo.getOffset(), register);
        } else {
            throw new RuntimeException("Unidentifiable variable");
        }
    }

    private String storeInstruction(String register, TACReference reference, int size) {
        VariablesTable.VariableInfo variableInfo = getVariableInfoOrThrowException(reference);
        if (isLocalVariable(variableInfo) || initialScope) {
            return String.format("\t%s\t%s, %s(%%rbp)", instructionCode("mov", size), register, variableInfo.getOffset());
        } else if (isLocalArgument(variableInfo)) {
            return String.format("\t%s\t%s, %s(%%rbp)", instructionCode("mov", size), register, variableInfo.getOffset() + 8);
        } else if (isGlobalVariable(variableInfo)) {
            return String.format("""
                    \tmovq\tdecl_2@GOTPCREL(%%rip), %%rsi
                    \tmovq\t(%%rsi), %%rsi
                    \t%s\t%s, %s(%%rsi)
                    """, instructionCode("mov", size), register, variableInfo.getOffset());
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

    private String instructionCode(String instruction, int size) {
        return instruction + sizeCode(size);
    }

    private String sizeCode(int bytes) {
        return switch (bytes) {
            case 1 -> "b";
            case 4 -> "l";
            case 8 -> "q";
            default -> throw new RuntimeException("Invalid size code " + bytes + "B. Valid options: 1B, 4B and 8B");
        };
    }

    private String register(String name, int size) {
        return new x86RegisterFactory().getRegister(name).name(size);
    }
}
