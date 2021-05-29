package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

import java.util.List;

public final class PrintIntegerSubprogram extends AssemblyLibrarySubprogram {
    public PrintIntegerSubprogram() {}

    public PrintIntegerSubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        super(dependencies);
    }

    @Override
    public String alias() {
        return "print_uint64";
    }

    @Override
    public String assemblyCode() {
        return """
                print_uint64:
                \tlea \t-1(%rsp), %rsi
                \tmovb\t$'\\n', (%rsi)
                \tmov \t$10, %ecx
                \tmovl\t%edi, %ebx
                \ttestl\t%edi, %edi
                \tjns \t.print_uint64_positive
                \tneg \t%edi
                    
                \t.print_uint64_positive:
                \t\tmov \t%rdi, %rax
                    
                \t.Ltoascii_digit:
                \t\txor \t%edx, %edx
                \t\tdiv \t%rcx
                \t\tadd \t$'0', %edx
                \t\tdec \t%rsi
                \t\tmov \t%dl, (%rsi)  
                \t\ttest\t%rax, %rax
                \t\tjnz \t.Ltoascii_digit
                \t\ttestl\t%ebx, %ebx
                \t\tjns \t.print_uint64_end
                \t\txor \t%edx, %edx
                \t\tdiv \t%rcx
                \t\tadd \t$'-', %edx
                \t\tdec \t%rsi
                \t\tmov \t%dl, (%rsi)  
                \t\ttest \t%rax, %rax
                    
                \t.print_uint64_end:
                \t\tmov \t$0x02000004, %eax
                \t\tmov \t$1, %edi
                \t\tmov \t%rsp, %rdx
                \t\tsub \t%rsi, %rdx
                \t\tsyscall
                \t\tret
                """;
    }
}
