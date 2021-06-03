package main;

import java.io.File;
import java.io.FileWriter;

public final class Main {
    private static final String UNOPTIMIZED_DIRECTORY_NAME = "/no_optimizado";
    private static final String OPTIMIZED_DIRECTORY_NAME = "/optimizado";

    private Main() {}

    public static void main(String[] args) {
        try {
            checkCorrectFormat(args);
            String parentDirectory = getParentFilePath(args[0]);
            createDirectoriesIfNecessary(parentDirectory);
            compile(args[0], parentDirectory, false);
            compile(args[0], parentDirectory, true);
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

    public static void createDirectoriesIfNecessary(String parentPath) throws Exception {
        createDirectoryIfNecessary(parentPath + UNOPTIMIZED_DIRECTORY_NAME);
        createDirectoryIfNecessary(parentPath + OPTIMIZED_DIRECTORY_NAME);
    }

    public static void createDirectoryIfNecessary(String path) throws Exception {
        File directory = new File(path);
        if (!directory.exists() && !directory.mkdir()) {
            throw new Exception("El directorio " + path + " no pudo ser creado");
        }
    }

    public static void compile(String sourcePath, String parentDirectory, boolean optimized) throws Exception {
        String path = optimized ? parentDirectory + OPTIMIZED_DIRECTORY_NAME : parentDirectory + UNOPTIMIZED_DIRECTORY_NAME;
        Compiler compiler = new Compiler(sourcePath);
        compiler.compile(
                null,
                null,
                null,
                new FileWriter(path + "/3ac.txt"),
                new FileWriter(path + "/tabla_variables.txt"),
                new FileWriter(path + "/taula_subprogramas.txt"),
                new FileWriter(path + "/assembly.asm"),
                new FileWriter(path + "/errores.txt"),
                optimized
        );
    }
}
