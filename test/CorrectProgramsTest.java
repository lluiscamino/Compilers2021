import main.Compiler;
import org.junit.Test;

import java.io.StringWriter;

public final class CorrectProgramsTest {

    @Test
    public void testArrayAssignment() throws Exception {
        final String expectedSymbolTable = "1: procedure main (0 args)\n" +
                "\t2: const INT a\n" +
                "\t3: const INT_ARR Dimensions:1 b\n" +
                "\t4: var INT_ARR Dimensions:1 unidimensional\n" +
                "\t5: var INT_ARR Dimensions:2 bidimensional\n" +
                "\t6: var INT_ARR Dimensions:3 tridimensional\n" +
                "\t\t32: var INT i\n" +
                "\t\t\t33: var INT j\n";
        testProgram("arrayassignment", expectedSymbolTable);
    }

    @Test
    public void testArrayDeclaration() throws Exception {
        final String expectedSymbolTable = "1: procedure main (0 args)\n" +
                "\t2: const INT_ARR Dimensions:1 unidimensional\n" +
                "\t3: const INT_ARR Dimensions:2 bidimensional\n" +
                "\t4: var INT_ARR Dimensions:3 tridimensional\n";
        testProgram("arraydeclaration", expectedSymbolTable);
    }

    @Test
    public void testBinarySearch() throws Exception {
        final String expectedSymbolTable = "1: function binarySearch INT (2 args)\n" +
                "\t1: var INT_ARR Dimensions:1 nums\n" +
                "\t1: var INT target\n" +
                "\t2: var INT left\n" +
                "\t3: var INT right\n" +
                "\t4: var INT result\n" +
                "\t5: var BOOLEAN res\n" +
                "\t\t7: const INT middle\n" +
                "21: procedure main (0 args)\n" +
                "\t22: const INT_ARR Dimensions:1 arr\n" +
                "\t23: const INT target\n" +
                "\t24: const INT result\n";
        testProgram("binarysearch", expectedSymbolTable);
    }

    @Test
    public void testComments() throws Exception {
        final String expectedSymbolTable = "1: procedure hola (1 args)\n" +
                "\t1: var INT b\n" +
                "\t4: var INT a\n" +
                "8: procedure main (0 args)\n";
        testProgram("comments", expectedSymbolTable);
    }

    @Test
    public void testConditional() throws Exception {
        final String expectedSymbolTable = "1: function f INT (3 args)\n" +
                "\t1: var BOOLEAN a\n" +
                "\t1: var BOOLEAN c\n" +
                "\t1: var BOOLEAN d\n" +
                "\t2: var INT e\n" +
                "\t3: const BOOLEAN b\n" +
                "\t4: var STRING h\n" +
                "9: function max INT (2 args)\n" +
                "\t9: var INT a\n" +
                "\t9: var INT b\n" +
                "13: function Int2Bool BOOLEAN (1 args)\n" +
                "\t13: var INT val\n" +
                "17: procedure main (0 args)\n" +
                "\t18: var INT f\n";
        testProgram("conditional", expectedSymbolTable);
    }

    @Test
    public void testFor() throws Exception {
        final String expectedSymbolTable = "1: procedure loopForever (0 args)\n" +
                "5: procedure main (0 args)\n" +
                "\t6: var INT_ARR Dimensions:1 arr\n" +
                "\t\t7: var INT i\n" +
                "\t\t10: var INT i\n" +
                "\t\t13: var INT i\n" +
                "\t17: var INT i\n" +
                "\t18: var BOOLEAN repeat\n" +
                "\t\t25: var INT i\n" +
                "\t\t25: var INT j\n";
        testProgram("for", expectedSymbolTable);
    }

    @Test
    public void testForeach() throws Exception {
        final String expectedSymbolTable = "1: procedure main (0 args)\n" +
                "\t2: const STRING_ARR Dimensions:1 cities\n" +
                "\t3: const STRING city\n" +
                "\t\t4: const STRING city\n" +
                "\t\t7: var STRING city\n" +
                "\t\t10: const STRING country\n" +
                "\t\t13: const INT num\n" +
                "\t\t16: const BOOLEAN_ARR Dimensions:1 arr\n" +
                "\t\t\t17: const BOOLEAN val\n";
        testProgram("foreach", expectedSymbolTable);
    }

    @Test
    public void testIf() throws Exception {
        final String expectedSymbolTable = "1: function loremIpsum BOOLEAN (1 args)\n" +
                "\t1: var BOOLEAN c\n" +
                "5: procedure main (0 args)\n" +
                "\t6: const BOOLEAN condition\n" +
                "\t7: const BOOLEAN_ARR Dimensions:2 conditions\n";
        testProgram("if", expectedSymbolTable);
    }

    @Test
    public void testProcedureCall() throws Exception {
        final String expectedSymbolTable = "1: procedure proc1 (1 args)\n" +
                "\t1: var STRING text\n" +
                "6: procedure proc2 (2 args)\n" +
                "\t6: var INT a\n" +
                "\t6: var BOOLEAN b\n" +
                "15: procedure proc3 (1 args)\n" +
                "\t15: var INT a\n" +
                "19: procedure proc4 (2 args)\n" +
                "\t19: var INT num\n" +
                "\t19: var BOOLEAN b\n" +
                "25: procedure proc5 (2 args)\n" +
                "\t25: var INT num1\n" +
                "\t25: var INT num2\n" +
                "33: procedure proc6 (1 args)\n" +
                "\t33: var STRING_ARR Dimensions:1 messages\n" +
                "38: procedure main (0 args)\n" +
                "\t39: var STRING text\n" +
                "\t40: var STRING_ARR Dimensions:1 msgs\n";
        testProgram("procedurecall", expectedSymbolTable);
    }

    @Test
    public void testRelational() throws Exception {
        final String expectedSymbolTable = "1: procedure main (0 args)\n" +
                "\t5: const STRING_ARR Dimensions:1 strings\n" +
                "\t12: var STRING h\n" +
                "\t13: var INT a\n";
        testProgram("relational", expectedSymbolTable);
    }

    @Test
    public void testSortStrings() throws Exception {
        final String expectedSymbolTable = "3: function bubbleSort STRING_ARR Dimensions:1 (1 args)\n" +
                "\t3: var STRING_ARR Dimensions:1 arr\n" +
                "\t4: var INT n\n" +
                "\t5: var BOOLEAN swapped\n" +
                "\t\t6: var INT i\n" +
                "\t\t\t8: var INT j\n" +
                "\t\t\t\t11: var STRING aux\n" +
                "20: function readStringArray STRING_ARR Dimensions:1 (1 args)\n" +
                "\t20: var INT len\n" +
                "\t21: var STRING_ARR Dimensions:1 arr\n" +
                "\t\t22: var INT i\n" +
                "\t\t24: var STRING str\n" +
                "30: procedure main (1 args)\n" +
                "\t30: var INT arrLength\n" +
                "\t31: const STRING_ARR Dimensions:1 input\n";
        testProgram("sortstrings", expectedSymbolTable);
    }

    @Test
    public void testStringLiteral() throws Exception {
        final String expectedSymbolTable = "1: procedure empty (1 args)\n" +
                "\t1: var STRING text\n" +
                "6: procedure main (0 args)\n" +
                "\t7: var STRING a\n";
        testProgram("stringliteral", expectedSymbolTable);
    }

    @Test
    public void twoSum() throws Exception {
        final String expectedSymbolTable = "1: const INT_ARR Dimensions:1 noResult\n" +
                "10: function twoSum INT_ARR Dimensions:1 (2 args)\n" +
                "\t10: var INT_ARR Dimensions:1 nums\n" +
                "\t10: var INT target\n" +
                "\t11: var INT_ARR Dimensions:1 result\n" +
                "\t12: var INT i\n" +
                "\t13: var BOOLEAN res\n" +
                "\t\t15: var INT j\n" +
                "28: procedure main (0 args)\n" +
                "\t29: const INT_ARR Dimensions:1 result\n";
        testProgram("twosum", expectedSymbolTable);
    }

    @Test
    public void testWhile() throws Exception {
        final String expectedSymbolTable = "1: procedure doSomething (1 args)\n" +
                "\t1: var BOOLEAN val\n" +
                "7: procedure main (0 args)\n" +
                "\t12: var BOOLEAN condition\n" +
                "\t13: var INT counter\n";
        testProgram("while", expectedSymbolTable);
    }

    private void testProgram(final String programName, final String expectedSymbolTable) throws Exception {
        final String programPath = "test/correctsources/" + programName;
        final StringWriter
                tokensWriter = new StringWriter(),
                symbolTableWriter = new StringWriter(),
                treeWriter = new StringWriter(),
                errorsWriter = new StringWriter();
        Compiler compiler = new Compiler(programPath, tokensWriter, symbolTableWriter, treeWriter, errorsWriter);
        compiler.compile();
        assert compiler.getErrorsList().isEmpty();
        assert errorsWriter.toString().length() == 0;
        assert symbolTableWriter.toString().equals(expectedSymbolTable);
    }
}
