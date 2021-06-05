package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

import java.util.List;

import static assembly.x86.AssemblyCodeGenerationConstants.FALSE;
import static assembly.x86.AssemblyCodeGenerationConstants.TRUE;

public final class CompareStringsSubprogram extends AssemblyLibrarySubprogram {
    public CompareStringsSubprogram() {}

    public CompareStringsSubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        super(dependencies);
    }

    @Override
    public String alias() {
        return "compare_strings";
    }

    @Override
    public String assemblyCode() {
        return String.format("""
                /**
                 * Compares two strings (saves result to %%dl)
                 * Params:
                 * - %%rsi: First string address
                 * - %%rdi: Second string address
                 */
                compare_strings:
                \tlea \t-1(%%rsi), %%rcx
                \tlea \t-1(%%rdi), %%rdx
                \t.Cloop:
                \t\tinc \t%%rcx
                \t\tinc \t%%rdx
                \t\tcmpb\t$0, (%%rcx)
                \t\tjne \t.compare_strings_continue
                \t\tcmpb\t$0, (%%rdx)
                \t\tje  \t.compare_strings_true
                \t\t.compare_strings_continue:
                \t\t\tmovb\t(%%rcx), %%al
                \t\t\tcmpb\t%%al, (%%rdx)
                \t\t\tje  \t.Cloop
                \t.compare_strings_false:
                \t\tmovb\t$%s, %%dl
                \t\tjmp \t.compare_strings_end
                \t.compare_strings_true:
                \t\tmovb\t$%s, %%dl
                \t.compare_strings_end:
                \t\tret
                """,
                FALSE,
                TRUE
        );
    }
}
