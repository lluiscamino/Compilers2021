package assembly;

import main.Compiler;
import tac.instructions.arithmetic.*;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
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
import tac.instructions.subprogram.ComplexParameterInstruction;
import tac.instructions.subprogram.PreambleInstruction;
import tac.instructions.subprogram.ReturnInstruction;
import tac.instructions.subprogram.SimpleParameterInstruction;
import tac.instructions.subprogram.calls.FunctionCallInstruction;
import tac.instructions.subprogram.calls.ProcedureCallInstruction;
import tac.references.TACLiteral;
import tac.references.TACReference;
import tac.references.TACSubprogram;
import tac.references.TACVariable;
import tac.tables.SubprogramsTable;
import tac.tables.VariablesTable;

public class x86CodeGenerator implements AssemblyCodeGenerator {
    @Override
    public String preamble() {
        SubprogramsTable subprogramsTable = Compiler.getCompiler().getSemanticAnalyzer().getSubprogramsTable();
        return String.format("""
                        .section __DATA, __data
                        true_str:
                          .asciz "true\\n"
                        false_str:
                          .asciz "false\\n"
                        .section __TEXT, __text
                        .globl _main
                        .globl print_uint64
                        .globl print_boolean
                        .globl print_char
                        %s
                        %s
                        %s
                        _main:
                        jmp %s
                        """,
                printIntegerFunction(),
                printBooleanFunction(),
                printCharFunction(),
                subprogramsTable.get("main").getTag()
        );
    }

    private String printIntegerFunction() {
        return """
                print_uint64:
                    lea   -1(%rsp), %rsi
                    movb  $'\\n', (%rsi)
                    mov    $10, %ecx
                    movl %edi, %ebx
                    testl %edi, %edi
                    jns .print_uint64_positive
                    neg %edi
                    
                .print_uint64_positive:
                    mov    %rdi, %rax
                    
                .Ltoascii_digit:
                    xor    %edx, %edx
                    div    %rcx
                    add    $'0', %edx
                    dec    %rsi
                    mov    %dl, (%rsi)  
                    test   %rax, %rax
                    jnz  .Ltoascii_digit
                    testl %ebx, %ebx
                    jns .print_uint64_end
                    xor    %edx, %edx
                    div    %rcx
                    add    $'-', %edx
                    dec    %rsi
                    mov    %dl, (%rsi)  
                    test   %rax, %rax
                    
                .print_uint64_end:
                    mov   $0x02000004, %eax
                    mov   $1, %edi
                    mov   %rsp, %rdx
                    sub   %rsi, %rdx
                    syscall
                    ret
                """;
    }

    private String printBooleanFunction() {
        return """
                print_boolean:
                    mov   $0x02000004, %rax
                    mov   $1, %rdi
                    testl %ebx, %ebx
                    jnz   .print_boolean_true
                    movq  false_str@GOTPCREL(%rip), %rsi
                    mov   $6, %rdx
                    jmp   .print_boolean_end
                .print_boolean_true:
                    movq  true_str@GOTPCREL(%rip), %rsi
                    mov   $5, %rdx
                .print_boolean_end:
                    syscall
                    ret
                """;
    }

    private String printCharFunction() {
        return """
                print_char:
                    mov   $0x02000004, %eax
                    mov   $1, %edi
                    mov   $1, %rdx
                    mov   $'H', %rsi
                    syscall
                    ret
                """;
    }

    @Override
    public String epilogue() {
        return """
                mov $0x02000001, %rax
                xor $0, %rdi
                syscall
                """;
    }

    @Override
    public String generate(AddInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        addl %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(CopyInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(DivideInstruction tacInstruction) {
        return String.format("""
                        %s
                        movl %%eax, %%edx
                        sarl $31, %%edx
                        %s
                        idivl %%ebx
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ModuloInstruction tacInstruction) {
        return String.format("""
                        %s
                        movl %%eax, %%edx
                        sarl $31, %%edx
                        %s
                        idivl %%ebx
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%edx", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(NegativeInstruction tacInstruction) {
        return String.format("""
                        xorl %%eax, %%eax
                        %s
                        subl %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ProductInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        imull %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(SubtractInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        subl %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
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
    public String generate(GotoInstruction tacInstruction) {
        return "jmp " + tacInstruction.getFirstReference() + "\n";
    }

    @Override
    public String generate(SkipInstruction tacInstruction) {
        return tacInstruction.getFirstReference() + ": nop\n";
    }

    @Override
    public String generate(AndInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        andl %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(NotInstruction tacInstruction) {
        return String.format("""
                        xorl %%eax, %%eax
                        %s
                        notl %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(OrInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        orl %%ebx, %%eax
                        %s
                        """,
                loadInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(IndexAssignmentInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        add %%rbx, %%rcx
                        %s
                        movl %%ebx, (%%rcx)
                        """,
                loadAddressInstruction(tacInstruction.getFirstReference(), "%rcx"),
                loadInstruction(tacInstruction.getSecondReference(), "%ebx"),
                loadInstruction(tacInstruction.getThirdReference(), "%ebx")
        );
    }

    @Override
    public String generate(IndexedValueInstruction tacInstruction) {
        return String.format("""
                        %s
                        %s
                        addl %%ebx, %%eax
                        movl (%%eax), %%eax
                        %s
                        """,
                loadAddressInstruction(tacInstruction.getSecondReference(), "%eax"),
                loadAddressInstruction(tacInstruction.getThirdReference(), "%ebx"),
                storeInstruction("%eax", tacInstruction.getFirstReference())
        );
    }

    @Override
    public String generate(ProcedureCallInstruction tacInstruction) {
        SubprogramsTable subprogramsTable = Compiler.getCompiler().getSemanticAnalyzer().getSubprogramsTable();
        SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get((TACSubprogram) tacInstruction.getFirstReference());
        return "call " + subprogramInfo.getTag() + "\n";
    }

    @Override
    public String generate(FunctionCallInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(ComplexParameterInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(PreambleInstruction tacInstruction) {
        SubprogramsTable subprogramsTable = Compiler.getCompiler().getSemanticAnalyzer().getSubprogramsTable();
        SubprogramsTable.SubprogramInfo subprogramInfo = subprogramsTable.get((TACSubprogram) tacInstruction.getFirstReference());
        return String.format("""
                push %%rbp
                mov %%rsp, %%rbp
                /*addq $%s, %%rbp*/
                subq $%s, %%rsp
                """,
                0,
                subprogramInfo.getLocalVariablesSize()
        );
    }

    @Override
    public String generate(ReturnInstruction tacInstruction) {
        return """
                movq %rbp, %rsp
                popq %rbp
                ret
                """;
    }

    @Override
    public String generate(SimpleParameterInstruction tacInstruction) {
        return String.format("""
                %s
                push %%eax
                """,
                loadInstruction(tacInstruction.getFirstReference(), "%eax")
        );
    }

    @Override
    public String generate(ReadInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(PrintIntInstruction tacInstruction) {
        return String.format("""
                %s
                call print_uint64
                """,
                loadInstruction(tacInstruction.getFirstReference(), "%edi")
        );
    }

    @Override
    public String generate(PrintBooleanInstruction tacInstruction) {
        return String.format("""
                %s
                call print_boolean
                """,
                loadInstruction(tacInstruction.getFirstReference(), "%ebx")
        );
    }

    @Override
    public String generate(PrintStringInstruction tacInstruction) {
        return "call print_char\n";
    }

    @Override
    public String generate(PrintArrayInstruction tacInstruction) {
        return null;
    }

    private String loadInstruction(TACReference reference, String register) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        String assembly = "";
        if (reference instanceof TACLiteral) {
            assembly += String.format("movl $%s, %s", reference, register);
            return assembly;
        }
        VariablesTable.VariableInfo variableInfo = variablesTable.get((TACVariable) reference);
        if (variableInfo.getScope().getIndentation() >= 1 && !variableInfo.isSubprogramArgument()) { // local variable
            assembly += String.format("movl %s(%%rbp), %s", variableInfo.getOffset(), register);
            return assembly;
        }
        if (variableInfo.getScope().getIndentation() >= 1 && variableInfo.isSubprogramArgument()) { // local argument
            assembly += String.format("movl %s(%%rbp), %%esi\n", variableInfo.getScope().getIndentation());
            assembly += String.format("movl (%%esi), %s", register);
            return assembly;
        }
        if (variableInfo.getScope().getIndentation() < 1 && !variableInfo.isSubprogramArgument()) {
            assembly += "movl $DISP, %esi\n";
            assembly += String.format("movl %s(%%esi), %%esi\n", variableInfo.getScope().getIndentation());
            assembly += String.format("movl %s(%%esi), %s", variableInfo.getOffset(), register);
            return assembly;
        }
        return assembly;
    }

    private String storeInstruction(String register, TACReference reference) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        VariablesTable.VariableInfo variableInfo = variablesTable.get((TACVariable) reference);
        String assembly = "";
        if (variableInfo.getScope().getIndentation() >= 1 && !variableInfo.isSubprogramArgument()) { // local variable
            assembly += String.format("movl %s, %s(%%rbp)", register, variableInfo.getOffset());
            return assembly;
        }
        if (variableInfo.getScope().getIndentation() >= 1 && variableInfo.isSubprogramArgument()) { // local argument
            assembly += String.format("movl %s(%%epb), %%edi\n", variableInfo.getOffset());
            assembly += String.format("movl %s, (%%edi)", reference);
            return assembly;
        }
        if (variableInfo.getScope().getIndentation() < 1 && !variableInfo.isSubprogramArgument()) {
            assembly += "movl $DISP, %esi\n";
            assembly += String.format("movl %s(%%esi), %%edi\n", variableInfo.getScope().getIndentation());
            assembly += String.format("movl %s, %s(%%edi)", register, variableInfo.getOffset());
            return assembly;
        }
        return assembly;
    }

    private String loadAddressInstruction(TACReference reference, String register) {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        VariablesTable.VariableInfo variableInfo = variablesTable.get((TACVariable) reference);
        String assembly = "";
        if (variableInfo.getScope().getIndentation() >= 1 && !variableInfo.isSubprogramArgument()) { // local variable
            assembly += String.format("lea %s(%%rbp), %s", variableInfo.getOffset(), register);
            return assembly;
        }
        if (variableInfo.getScope().getIndentation() >= 1 && variableInfo.isSubprogramArgument()) { // local argument
            assembly += String.format("movl %s(%%rbp), %s", variableInfo.getOffset(), register);
            return assembly;
        }
        if (variableInfo.getScope().getIndentation() < 1 && !variableInfo.isSubprogramArgument()) {
            assembly += "movl $DISP, %esi\n";
            assembly += String.format("movl %s(%%esi), %%esi\n", variableInfo.getScope().getIndentation());
            assembly += String.format("movl %s(%%esi), %s", variableInfo.getOffset(), register);
            return assembly;
        }
        return assembly;
    }

    private String generateIfInstruction(IfInstruction tacInstruction, String comparisonCode) {
        return String.format("""
                        %s
                        %s
                        cmpl %%ebx, %%eax
                        %s 1f
                        jmp %s
                        1: nop
                        """,
                loadInstruction(tacInstruction.getFirstReference(), "%eax"),
                loadInstruction(tacInstruction.getSecondReference(), "%ebx"),
                comparisonCode,
                tacInstruction.getThirdReference()
        );
    }
}
