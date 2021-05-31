package assembly.x86.subprograms;

import assembly.AssemblyLibrarySubprogram;

public final class AllocateDynamicMemory extends AssemblyLibrarySubprogram {
    public AllocateDynamicMemory() {}

    @Override
    public String alias() {
        return "dynalloc";
    }

    @Override
    public String assemblyCode() {
        return """
                dynalloc:
                /*pmb s0*/
                \tpush\t%rbp
                \tmov \t%rsp, %rbp
                \tsubq\t$0, %rsp
                \tmovq\t16(%rbp), %rdi
                \tcall\t_malloc
                \tmovq\t%rbp, %rsp
                \tpop\t%rbp
                \tret
                """;
    }
}
