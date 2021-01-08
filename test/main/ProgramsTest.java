package main;

import java.io.File;

public class ProgramsTest {

    private static final String PROGRAMS_PATH = "test/programs/";
    
    public static void main(String[] args) throws Exception {
        File path = new File(PROGRAMS_PATH + "correct");
        File[] programs = path.listFiles();
        for (File program : programs) {
            try {
                Compiler compiler = new Compiler(program.getAbsolutePath());
                compiler.parse();
                System.out.println(program.getName() + " OK!");
            } catch (Exception e) {
                System.err.println("Problem with program " + program.getName());
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }
        System.out.println("All tests passed!");
    }
}
