package main;

import org.junit.Test;

import java.io.FileNotFoundException;

public class ProgramsTest {

    private static final String PROGRAMS_PATH = "C:\\Users\\lluis\\Documents\\NetBeansProjects\\Compiladores2020\\test\\programs\\";

    private Compiler getCompiler(String programName) throws FileNotFoundException {
        return new Compiler(PROGRAMS_PATH + programName);
    }

    @Test
    public void testProgram1() throws Exception {
        Compiler compiler = getCompiler("test_program1.txt");
        compiler.parse();
    }

    @Test(expected = Exception.class)
    public void testProgram2() throws Exception { // Program needs main
        Compiler compiler = getCompiler("test_program2.txt");
        compiler.parse();
    }

    @Test
    public void testProgram3() throws Exception { // Array declaration
        Compiler compiler = getCompiler("test_program3.txt");
        compiler.parse();
    }
}
