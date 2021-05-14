package assembly;

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
import tac.instructions.io.print.*;
import tac.instructions.subprogram.*;
import tac.instructions.subprogram.calls.FunctionCallInstruction;
import tac.instructions.subprogram.calls.ProcedureCallInstruction;
import tac.references.TACLiteral;
import tac.references.TACReference;

public class x86CodeGenerator implements AssemblyCodeGenerator {
    @Override
    public String generate(AddInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        addl %%ebx, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(CopyInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(DivideInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        movl %%eax, %%edx
                        sarl $31, %%edx
                        LD %s, %%ebx
                        idivl %%ebx
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(ModuloInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        movl %%eax, %%edx
                        sarl $31, %%edx
                        LD %s, %%ebx
                        idivl %%ebx
                        ST %%edx, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(NegativeInstruction tacInstruction) {
        return String.format("""
                        xorl %%eax, %%eax
                        LD %s, %%ebx
                        subl %%ebx, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(ProductInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        imull %%ebx, %%eax
                        ST %%ebx, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(SubtractInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        subl %%ebx, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
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
        return generateIfInstruction(tacInstruction, "jgt");
    }

    @Override
    public String generate(IfLess tacInstruction) {
        return generateIfInstruction(tacInstruction, "jge");
    }

    @Override
    public String generate(GotoInstruction tacInstruction) {
        return "jmp " + tacInstruction.getFirstReference();
    }

    @Override
    public String generate(SkipInstruction tacInstruction) {
        return tacInstruction.getFirstReference() + " : nop";
    }

    @Override
    public String generate(AndInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        andl %%ebx, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(NotInstruction tacInstruction) {
        return String.format("""
                        xorl %%eax, %%eax
                        LD %s, %%ebx
                        notl %%ebx, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(OrInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        orl %%ebx, %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(IndexAssignmentInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        addl %%ebx, %%eax
                        LD %s, %%ebx
                        ST %%ebx, (%%eax)
                        """,
                tacInstruction.getFirstReference(),
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference()
        );
    }

    @Override
    public String generate(IndexedValueInstruction tacInstruction) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        addl %%ebx, %%eax
                        movl (%%eax), %%eax
                        ST %%eax, %s
                        """,
                tacInstruction.getSecondReference(),
                tacInstruction.getThirdReference(),
                tacInstruction.getFirstReference()
        );
    }

    @Override
    public String generate(ProcedureCallInstruction tacInstruction) {
        return null;
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
        return null;
    }

    @Override
    public String generate(ReturnInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(SimpleParameterInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(ReadInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(PrintIntInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(PrintBooleanInstruction tacInstruction) {
        return null;
    }

    @Override
    public String generate(ArrayLengthInstruction tacInstruction) {
        return null;
    }

    private String generateIfInstruction(IfInstruction tacInstruction, String comparisonCode) {
        return String.format("""
                        LD %s, %%eax
                        LD %s, %%ebx
                        cmpl %%eax, %%ebx
                        %s ne
                        jmp %s
                        ne: nop
                        """,
                tacInstruction.getFirstReference(),
                tacInstruction.getSecondReference(),
                comparisonCode,
                tacInstruction.getThirdReference()
        );
    }
}
