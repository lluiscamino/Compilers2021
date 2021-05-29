package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

import java.util.List;

import static assembly.x86.AssemblyCodeGenerationConstants.STRING_BUFFER_BYTES;

public final class GetStringLengthSubprogram extends AssemblyLibrarySubprogram {
    public GetStringLengthSubprogram() {}

    public GetStringLengthSubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        super(dependencies);
    }

    @Override
    public String alias() {
        return "string_length";
    }

    @Override
    public String assemblyCode() {
        return """
                /**
                 * Returns a string's length (saves to %rdx)
                 * Params:
                 * - %rsi: String address
                 * https://stackoverflow.com/questions/60482733/how-to-traverse-a-string-in-assembly-until-i-reach-null-strlen-loop
                 */
                string_length:
                \tlea \t-1(%rsi), %rdx
                \t.Lloop:
                \t\tinc \t%rdx
                \t\tcmpb\t$0, (%rdx)
                \t\tjne \t.Lloop
                \tsub \t%rsi, %rdx
                \tret
                """;
    }
}
