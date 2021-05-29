package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

import java.util.List;

public final class PrintStringSubprogram extends AssemblyLibrarySubprogram {
    public PrintStringSubprogram() {}

    public PrintStringSubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        super(dependencies);
    }

    @Override
    public String alias() {
        return "print_string";
    }

    @Override
    public String assemblyCode() {
        return """
                /**
                 * Prints a string to stdout
                 * Params:
                 * - %rsi: String address
                 */
                print_string:
                \tcall\tstring_length
                \tmov \t$0x02000004, %rax
                \tmov \t$1, %rdi
                \tsyscall
                \tret
                """;
    }
}
