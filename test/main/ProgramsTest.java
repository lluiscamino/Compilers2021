package main;

import java.io.File;

public class ProgramsTest {

    private static final String PROGRAMS_PATH = "test/programs/correct/";
    private static final String TOKENS_PATH = PROGRAMS_PATH + "tokens/";
    private static final String TREE_PATH = PROGRAMS_PATH + "trees/";
    private static final String ERRORS_PATH = PROGRAMS_PATH + "errors/";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        File path = new File(PROGRAMS_PATH);
        File[] programs = path.listFiles();
        new File(TOKENS_PATH).mkdirs();
        new File(TREE_PATH).mkdirs();
        new File(ERRORS_PATH).mkdirs();
        int passedTests = 0;
        for (File program : programs) {
            if (program.isDirectory()) continue;
            String name = program.getName();
            String tokensPath = TOKENS_PATH + name + ".txt";
            String treePath = TREE_PATH + name + ".dot";
            String errorsPath = ERRORS_PATH + name + ".log";
            try {
                Compiler compiler = new Compiler(program.getAbsolutePath(), tokensPath, treePath, errorsPath);
                compiler.compile();
                if (Compiler.getCompiler().getErrorsList().isEmpty()) {
                    passedTests++;
                    System.out.println(name + " OK!");
                } else {
                    System.out.println("Problem with program " + name + ". Check " + errorsPath + " for details");
                }
            } catch (Exception e) {
                System.out.println("Unexpected exception with program " + name + ": " + e.getMessage());
            }
        }
        System.out.println("\nSUMMARY:\nTests passed:\t" + passedTests + "\nTests executed:\t"
                + programs.length + "\nSuccess rate:\t" + ((float) passedTests / programs.length) + "%");
    }
}
