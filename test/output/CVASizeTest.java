package output;

import main.Compiler;
import tac.tables.SubprogramsTable;
import tac.tables.VariablesTable;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public final class CVASizeTest {
    private CVASizeTest() {}

    public int countCVAsSize(boolean optimized) throws IOException {
        AtomicInteger cvaSize = new AtomicInteger();
        Files.find(Paths.get("test/output/sources"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .forEach(filePath -> {
                    try {
                        Compiler compiler = new Compiler(filePath.toString());
                        compiler.compile(null, null, null, null, null, null, new StringWriter(), null, optimized, 10000);
                        if (!compiler.getErrorsList().isEmpty()) {
                            System.out.println("Error(s) with program " + filePath.getFileName() + ":");
                            compiler.getErrorsList().forEach(System.out::println);
                        } else {
                            SubprogramsTable subprogramsTable = compiler.getSemanticAnalyzer().getSubprogramsTable();
                            VariablesTable variablesTable = compiler.getSemanticAnalyzer().getVariablesTable();
                            cvaSize.addAndGet(variablesTable.getGlobalVariablesSize());
                            for (SubprogramsTable.SubprogramInfo subprogram : subprogramsTable.subprograms()) {
                                cvaSize.addAndGet(subprogram.getLocalVariablesSize());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return cvaSize.get();
    }

    public static void main(String[] args) throws IOException {
        CVASizeTest CVAsSizeTest = new CVASizeTest();
        int unoptimizedCVAsSize = CVAsSizeTest.countCVAsSize(false),
                optimizedCVAsSize = CVAsSizeTest.countCVAsSize(true);
        System.out.printf("""
                        Unptimized CVA size:	%dB
                        Optimized CVA size:     %dB
                        Unopt./Opt.:	        %f%%""",
                unoptimizedCVAsSize, optimizedCVAsSize, (float) optimizedCVAsSize / (float) unoptimizedCVAsSize
        );
    }
}
