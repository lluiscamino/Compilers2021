package analyzers;

import java_cup.runtime.Symbol;
import parser.ParserSym;
import scanner.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

public final class LexicalAnalyzer extends Scanner {
    private final String inputPath;

    public LexicalAnalyzer(String inputPath) throws FileNotFoundException {
        super(new FileReader(inputPath));
        this.inputPath = inputPath;
    }

    public void writeTokenList(Writer writer) throws IOException {
        if (writer == null) {
            return;
        }
        StringBuilder buffer = new StringBuilder();
        Symbol tk = next_token();
        while (tk != null) {
            buffer.append(ParserSym.terminalNames[tk.sym]);
            buffer.append("\n");
            tk = next_token();
        }
        writer.write(buffer.toString());
        writer.close();
        yyreset(new FileReader(inputPath));
    }
}
