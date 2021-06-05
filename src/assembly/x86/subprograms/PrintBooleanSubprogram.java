package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

import java.util.List;

public final class PrintBooleanSubprogram extends AssemblyLibrarySubprogram {
    public PrintBooleanSubprogram() {}

    public PrintBooleanSubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        super(dependencies);
    }

    @Override
    public String alias() {
        return "print_boolean";
    }

    @Override
    public String assemblyCode() {
        return """
                /**
                 * Prints a boolean to stdout
                 * Params:
                 * - %bl: Boolean value
                 */
                print_boolean:
                \ttestb\t%bl, %bl
                \tjnz \t.print_boolean_true
                \tmovq\tdecl_1@GOTPCREL(%rip), %rsi
                \tjmp \t.print_boolean_end
                \t.print_boolean_true:
                \t\tmovq\tdecl_0@GOTPCREL(%rip), %rsi
                \t.print_boolean_end:
                \t\tcall \tprint_string
                \t\tret
                """;
    }
}
