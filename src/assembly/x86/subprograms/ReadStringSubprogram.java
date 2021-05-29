package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

import java.util.List;

import static assembly.x86.AssemblyCodeGenerationConstants.STRING_BUFFER_BYTES;

public final class ReadStringSubprogram extends AssemblyLibrarySubprogram {
    public ReadStringSubprogram() {}

    public ReadStringSubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        super(dependencies);
    }

    @Override
    public String alias() {
        return "read_string";
    }

    @Override
    public String assemblyCode() {
        return String.format("""
                /**
                 * Reads a string from stdin
                 * Params:
                 * - %%rsi: Address where the string will be saved
                 */
                read_string:
                \tmov \t$0x02000003, %%rax
                \tmov \t$0, %%rdi
                \tmovq\t$%s, %%rdx
                \tsyscall
                \tret
                """, STRING_BUFFER_BYTES
        );
    }
}
