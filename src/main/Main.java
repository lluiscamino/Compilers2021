package main;

import java.io.File;
import java.io.FileWriter;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        try {
            checkCorrectFormat(args);
            String directory = getParentFilePath(args[0]);
            Compiler compiler = new Compiler(args[0]);
            compiler.compile(
                    null,
                    null,
                    null,
                    new FileWriter(directory + "/3ac.txt"),
                    new FileWriter(directory + "/assembly.asm"),
                    new FileWriter(directory + "/errors.txt")
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void checkCorrectFormat(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("Formato incorrecto!\nFormato esperado: java -jar Compiladores.jar <PROGRAMA>");
        }
    }

    public static String getParentFilePath(String path) {
        return new File(path).getParentFile().getAbsolutePath();
    }
}
