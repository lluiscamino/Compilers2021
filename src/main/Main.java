package main;

import java.io.FileWriter;

public final class Main {
    private static String[] args;

    private Main() {
    }

    public static void main(String[] args) {
        try {
            Main.args = args;
            Compiler compiler = new Compiler(
                    getArg(0),
                    new FileWriter(getArg(1)),
                    new FileWriter(getArg(2)),
                    new FileWriter(getArg(3)),
                    new FileWriter(getArg(4))
            );
            compiler.compile();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static String getArg(int pos) throws Exception {
        if (args.length <= pos) {
            throw new Exception("Formato incorrecto!\nFormato esperado: java -jar Compiladores.jar <PROGRAMA> <TOKENS> <TABLA_SIMBOLOS> <ARBOL> <ERRORES>");
        }
        return args[pos];
    }
}
