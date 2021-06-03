package output;

import main.Compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public final class TACLinesOfCodeTest {
    private TACLinesOfCodeTest() {}

    public int countLinesOfCode(boolean optimized) throws IOException {
        AtomicInteger linesOfCode = new AtomicInteger();
        Files.find(Paths.get("test/output/sources"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .forEach(filePath -> {
                    try {
                        Compiler compiler = new Compiler(filePath.toString());
                        compiler.compile(null, null, null, null, null, null, null, null, optimized, 10000);
                        if (!compiler.getErrorsList().isEmpty()) {
                            System.out.println("Error(s) with program " + filePath.getFileName() + ":");
                            compiler.getErrorsList().forEach(System.out::println);
                        } else {
                            linesOfCode.addAndGet(compiler.getSemanticAnalyzer().getTacInstructionList().size());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return linesOfCode.get();
    }

    public static void main(String[] args) throws IOException {
        TACLinesOfCodeTest linesOfCodeTest = new TACLinesOfCodeTest();
        int unoptimizedLinesOfCode = linesOfCodeTest.countLinesOfCode(false),
                optimizedLinesOfCode = linesOfCodeTest.countLinesOfCode(true);
        System.out.printf("""
                        Unptimized L.O.C:	%d
                        Optimized L.O.C:	%d
                        Unopt./Opt.:	    %f%%""",
                unoptimizedLinesOfCode, optimizedLinesOfCode, (float) optimizedLinesOfCode / (float) unoptimizedLinesOfCode
        );
    }
}
