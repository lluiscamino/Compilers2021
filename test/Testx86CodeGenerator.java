import assembly.AssemblyCodeGenerator;
import assembly.x86CodeGenerator;
import org.junit.Test;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.*;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.*;
import tac.instructions.binary.AndInstruction;
import tac.instructions.binary.NotInstruction;
import tac.instructions.binary.OrInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACTag;
import tac.references.TACVariable;

public final class Testx86CodeGenerator {

    private final AssemblyCodeGenerator codeGenerator = new x86CodeGenerator();

    @Test
    public void testAddInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new AddInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                LD t2, %ebx
                addl %ebx, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testCopyInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACInstruction tacInstruction = new CopyInstruction(a, b);
        String expectedOutput = """
                LD t1, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testDivideInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new DivideInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                movl %eax, %edx
                sarl $31, %edx
                LD t2, %ebx
                idivl %ebx
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testModuloInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new ModuloInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                movl %eax, %edx
                sarl $31, %edx
                LD t2, %ebx
                idivl %ebx
                ST %edx, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testNegativeInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACInstruction tacInstruction = new NegativeInstruction(a, b);
        String expectedOutput = """
                xorl %eax, %eax
                LD t1, %ebx
                subl %ebx, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testProductInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new ProductInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                LD t2, %ebx
                imull %ebx, %eax
                ST %ebx, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testSubtractInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new SubtractInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                LD t2, %ebx
                subl %ebx, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIfDiffInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new IfDiff(a, b, e);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                cmpl %eax, %ebx
                je ne
                jmp e0
                ne: nop
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIfEqualInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new IfEqual(a, b, e);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                cmpl %eax, %ebx
                jne ne
                jmp e0
                ne: nop
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIfGEQInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new IfGEQ(a, b, e);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                cmpl %eax, %ebx
                jl ne
                jmp e0
                ne: nop
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIfGreaterInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new IfGreater(a, b, e);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                cmpl %eax, %ebx
                jle ne
                jmp e0
                ne: nop
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIfLEQInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new IfLEQ(a, b, e);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                cmpl %eax, %ebx
                jgt ne
                jmp e0
                ne: nop
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIfLessInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new IfLess(a, b, e);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                cmpl %eax, %ebx
                jge ne
                jmp e0
                ne: nop
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testGotoInstructionAssemblyOutput() {
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new GotoInstruction(e);
        String expectedOutput = "jmp e0";
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testSkipInstructionAssemblyOutput() {
        TACTag e = new TACTag(0);
        TACInstruction tacInstruction = new SkipInstruction(e);
        String expectedOutput = "e0 : nop";
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testAndInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new AndInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                LD t2, %ebx
                andl %ebx, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testNotInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1);
        TACInstruction tacInstruction = new NotInstruction(a, b);
        String expectedOutput = """
                xorl %eax, %eax
                LD t1, %ebx
                notl %ebx, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testOrInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new OrInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                LD t2, %ebx
                orl %ebx, %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIndexAssignmentInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new IndexAssignmentInstruction(a, b, c);
        String expectedOutput = """
                LD t0, %eax
                LD t1, %ebx
                addl %ebx, %eax
                LD t2, %ebx
                ST %ebx, (%eax)
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }

    @Test
    public void testIndexedValueInstructionAssemblyOutput() {
        TACVariable a = new TACVariable(0), b = new TACVariable(1), c = new TACVariable(2);
        TACInstruction tacInstruction = new IndexedValueInstruction(a, b, c);
        String expectedOutput = """
                LD t1, %eax
                LD t2, %ebx
                addl %ebx, %eax
                movl (%eax), %eax
                ST %eax, t0
                """;
        assert tacInstruction.toAssemblyCode(codeGenerator).equals(expectedOutput);
    }
}
