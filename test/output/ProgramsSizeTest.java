package output;

import main.Compiler;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public final class ProgramsSizeTest {
    private ProgramsSizeTest() {}

    public int countProgramsSize(boolean optimized) throws IOException {
        AtomicInteger programsSize = new AtomicInteger();
        Files.find(Paths.get("test/output/sources"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .forEach(filePath -> {
                    try {
                        Compiler compiler = new Compiler(filePath.toString());
                        Writer assemblyWriter = new StringWriter();
                        compiler.compile(null, null, null, null, null, null, null, assemblyWriter, null, optimized, 10000);
                        if (!compiler.getErrorsList().isEmpty()) {
                            System.out.println("Error(s) with program " + filePath.getFileName() + ":");
                            compiler.getErrorsList().forEach(System.out::println);
                        } else {
                            programsSize.addAndGet(assemblyWriter.toString().getBytes(StandardCharsets.UTF_8).length);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return programsSize.get();
    }

    public static void main(String[] args) throws IOException {
        ProgramsSizeTest programsSizeTest = new ProgramsSizeTest();
        int unoptimizedProgramsSize = programsSizeTest.countProgramsSize(false),
                optimizedProgramsSize = programsSizeTest.countProgramsSize(true);
        System.out.printf("""
                        Unptimized programs size:	%dB
                        Optimized programs size:    %dB
                        Unopt./Opt.:	            %f%%""",
                unoptimizedProgramsSize, optimizedProgramsSize, (float) optimizedProgramsSize / (float) unoptimizedProgramsSize
        );
    }
}
