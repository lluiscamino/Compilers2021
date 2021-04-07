package analyzers;

import java_cup.runtime.Symbol;
import parser.ParserSym;
import scanner.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public final class LexicalAnalyzer extends Scanner {
    private final String inputPath;
    private final PrintWriter tokensWriter;

    public LexicalAnalyzer(String inputPath, String tokensPath) throws FileNotFoundException {
        super(new FileReader(inputPath));
        this.inputPath = inputPath;
        this.tokensWriter = new PrintWriter(tokensPath);
    }

    public void writeTokenList() throws IOException {
        StringBuilder buffer = new StringBuilder();
        Symbol tk = next_token();
        while (tk != null) {
            buffer.append(ParserSym.terminalNames[tk.sym]);
            buffer.append("\n");
            tk = next_token();
        }
        tokensWriter.print(buffer.toString());
        tokensWriter.close();
        yyreset(new FileReader(inputPath));
    }
}
