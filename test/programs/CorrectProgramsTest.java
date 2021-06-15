package programs;

import main.Compiler;
import org.junit.Test;

import java.io.StringWriter;

public final class CorrectProgramsTest {

    @Test
    public void testArrayAssignment() throws Exception {
        final String expectedSymbolTable = """
                1: procedure main (0 args)
                \t2: const INT a
                \t3: const INT[] b
                \t4: var INT[] unidimensional
                \t5: var INT[][] bidimensional
                \t6: var INT[][][] tridimensional
                \t\t32: var INT i
                \t\t\t33: var INT j
                """;
        testProgram("arrayassignment", expectedSymbolTable);
    }

    @Test
    public void testArrayDeclaration() throws Exception {
        final String expectedSymbolTable = """
                1: procedure main (0 args)
                \t2: const INT[] unidimensional
                \t3: const INT[][] bidimensional
                \t4: var INT[][][] tridimensional
                """;
        testProgram("arraydeclaration", expectedSymbolTable);
    }

    @Test
    public void testBinarySearch() throws Exception {
        final String expectedSymbolTable = """
                1: function binarySearch INT (2 args)
                \t1: var INT[] nums
                \t1: var INT target
                \t2: var INT left
                \t3: var INT right
                \t4: var INT result
                \t5: var BOOLEAN res
                \t\t7: const INT middle
                21: procedure main (0 args)
                \t22: const INT[] arr
                \t23: const INT target
                \t24: const INT result
                """;
        testProgram("binarysearch", expectedSymbolTable);
    }

    @Test
    public void testComments() throws Exception {
        final String expectedSymbolTable = """
                1: procedure hola (1 args)
                \t1: var INT b
                \t4: var INT a
                8: procedure main (0 args)
                """;
        testProgram("comments", expectedSymbolTable);
    }

    @Test
    public void testConditional() throws Exception {
        final String expectedSymbolTable = """
                1: function f INT (3 args)
                \t1: var BOOLEAN a
                \t1: var BOOLEAN c
                \t1: var BOOLEAN d
                \t2: var INT e
                \t3: const BOOLEAN b
                \t4: var STRING h
                9: function max INT (2 args)
                \t9: var INT a
                \t9: var INT b
                13: function Int2Bool BOOLEAN (1 args)
                \t13: var INT val
                17: procedure main (0 args)
                \t18: var INT f
                """;
        testProgram("conditional", expectedSymbolTable);
    }

    @Test
    public void testFor() throws Exception {
        final String expectedSymbolTable = """
                1: procedure loopForever (0 args)
                5: procedure main (0 args)
                \t6: var INT[] arr
                \t\t7: var INT i
                \t\t10: var INT i
                \t\t13: var INT i
                \t17: var INT i
                \t18: var BOOLEAN repeat
                \t\t25: var INT i
                \t\t25: var INT j
                """;
        testProgram("for", expectedSymbolTable);
    }

    @Test
    public void testForeach() throws Exception {
        final String expectedSymbolTable = """
                1: procedure main (0 args)
                \t2: const STRING[] cities
                \t3: const STRING city
                \t\t4: const STRING city
                \t\t7: var STRING city
                \t\t10: const STRING country
                \t\t13: const INT num
                \t\t16: const BOOLEAN[] arr
                \t\t\t17: const BOOLEAN val
                """;
        testProgram("foreach", expectedSymbolTable);
    }

    @Test
    public void testIf() throws Exception {
        final String expectedSymbolTable = """
                1: function loremIpsum BOOLEAN (1 args)
                \t1: var BOOLEAN c
                5: procedure main (0 args)
                \t6: const BOOLEAN condition
                \t7: const BOOLEAN[][] conditions
                """;
        testProgram("if", expectedSymbolTable);
    }

    @Test
    public void testProcedureCall() throws Exception {
        final String expectedSymbolTable = """
                1: procedure proc1 (1 args)
                \t1: var STRING text
                6: procedure proc2 (2 args)
                \t6: var INT a
                \t6: var BOOLEAN b
                15: procedure proc3 (1 args)
                \t15: var INT a
                19: procedure proc4 (2 args)
                \t19: var INT num
                \t19: var BOOLEAN b
                25: procedure proc5 (2 args)
                \t25: var INT num1
                \t25: var INT num2
                33: procedure proc6 (1 args)
                \t33: var STRING[] messages
                38: procedure main (0 args)
                \t39: var STRING text
                \t40: var STRING[] msgs
                """;
        testProgram("procedurecall", expectedSymbolTable);
    }

    @Test
    public void testRelational() throws Exception {
        final String expectedSymbolTable = """
                1: procedure main (0 args)
                \t5: const STRING[] strings
                \t12: var STRING h
                \t13: var INT a
                """;
        testProgram("relational", expectedSymbolTable);
    }

    @Test
    public void testSortStrings() throws Exception {
        final String expectedSymbolTable = """
                3: function bubbleSort STRING[] (1 args)
                \t3: var STRING[] arr
                \t4: var INT n
                \t5: var BOOLEAN swapped
                \t\t6: var INT i
                \t\t\t8: var INT j
                \t\t\t\t11: var STRING aux
                20: function readStringArray STRING[] (1 args)
                \t20: var INT len
                \t21: var STRING[] arr
                \t\t22: var INT i
                \t\t24: var STRING str
                30: procedure main (1 args)
                \t30: var INT arrLength
                \t31: const STRING[] input
                """;
        testProgram("sortstrings", expectedSymbolTable);
    }

    @Test
    public void testStringLiteral() throws Exception {
        final String expectedSymbolTable = """
                1: procedure empty (1 args)
                \t1: var STRING text
                6: procedure main (0 args)
                \t7: var STRING a
                """;
        testProgram("stringliteral", expectedSymbolTable);
    }

    @Test
    public void twoSum() throws Exception {
        final String expectedSymbolTable = """
                1: const INT[] noResult
                10: function twoSum INT[] (2 args)
                \t10: var INT[] nums
                \t10: var INT target
                \t11: var INT[] result
                \t12: var INT i
                \t13: var BOOLEAN res
                \t\t15: var INT j
                28: procedure main (0 args)
                \t29: const INT[] result
                """;
        testProgram("twosum", expectedSymbolTable);
    }

    @Test
    public void testWhile() throws Exception {
        final String expectedSymbolTable = """
                1: procedure doSomething (1 args)
                \t1: var BOOLEAN val
                7: procedure main (0 args)
                \t12: var BOOLEAN condition
                \t13: var INT counter
                """;
        testProgram("while", expectedSymbolTable);
    }

    private void testProgram(final String programName, final String expectedSymbolTable) throws Exception {
        final String programPath = "test/programs/correctsources/" + programName;
        final StringWriter symbolTableWriter = new StringWriter(), errorsWriter = new StringWriter();
        Compiler compiler = new Compiler(programPath);
        compiler.compile(null, symbolTableWriter, null, null, null, null, null, null, errorsWriter, false, 1);
        assert compiler.getErrorsList().isEmpty();
        assert errorsWriter.toString().length() == 0;
        assert symbolTableWriter.toString().equals(expectedSymbolTable);
    }
}
