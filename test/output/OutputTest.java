package output;

import main.Compiler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class OutputTest {

    public void generateAssembly(boolean optimized) throws IOException {
        String directory = optimized ? "test/output/optimizedasm/" : "test/output/unoptimizedasm/";
        Files.find(Paths.get("test/output/sources"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .forEach(filePath -> {
                    try {
                        Writer assemblyWriter = new FileWriter(directory + filePath.getFileName() + ".asm");
                        Compiler compiler = new Compiler(filePath.toString());
                        compiler.compile(null, null, null, null, null, null, assemblyWriter, null, optimized, 10000);
                        if (!compiler.getErrorsList().isEmpty()) {
                            System.out.println("Error(s) with program " + filePath.getFileName() + ":");
                            compiler.getErrorsList().forEach(System.out::println);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void generateBashScript() throws IOException {
        Writer bashScriptWriter = new FileWriter("test/output/script.sh");
        bashScriptWriter.append("#! /bin/bash\n\n");
        Files.find(Paths.get("test/output/unoptimizedasm"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile() && filePath.toString().endsWith(".asm"))
                .forEach(filePath -> {
                    try {
                        String fileName = filePath.getFileName().toString();
                        bashScriptWriter.append(String.format("as optimizedasm/%s -o optimizedasm/%s.o\n", fileName, fileName));
                        bashScriptWriter.append(String.format("ld optimizedasm/%s.o -o optimizedasm/%s-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem\n", fileName, fileName));
                        bashScriptWriter.append(String.format("./optimizedasm/%s-exec > outputs/%s.txt\n", fileName, fileName));
                        bashScriptWriter.append(String.format("diff -y -q -w outputs/%s.txt expectedoutputs/%s.txt\n", fileName, fileName));
                        bashScriptWriter.append(String.format("rm optimizedasm/%s.o\n", fileName));
                        bashScriptWriter.append(String.format("rm optimizedasm/%s-exec\n\n", fileName));

                        bashScriptWriter.append(String.format("as unoptimizedasm/%s -o unoptimizedasm/%s.o\n", fileName, fileName));
                        bashScriptWriter.append(String.format("ld unoptimizedasm/%s.o -o unoptimizedasm/%s-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem\n", fileName, fileName));
                        bashScriptWriter.append(String.format("./unoptimizedasm/%s-exec > outputs/%s.txt\n", fileName, fileName));
                        bashScriptWriter.append(String.format("diff -y -q -w outputs/%s.txt expectedoutputs/%s.txt\n", fileName, fileName));
                        bashScriptWriter.append(String.format("rm unoptimizedasm/%s.o\n", fileName));
                        bashScriptWriter.append(String.format("rm unoptimizedasm/%s-exec\n\n", fileName));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        bashScriptWriter.close();
    }

    public static void main(String[] args) throws IOException {
        OutputTest outputTest = new OutputTest();
        outputTest.generateAssembly(false);
        outputTest.generateAssembly(true);
        outputTest.generateBashScript();
    }
}
