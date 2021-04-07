package analyzers;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import parser.Parser;
import parser.symbols.Program;

public final class SyntacticAnalyzer extends Parser {

    public SyntacticAnalyzer(LexicalAnalyzer scanner) {
        super(scanner, new ComplexSymbolFactory());
    }

    public Program getSyntaxTree() throws Exception {
        Symbol parseResult = parse();
        return parseResult != null && parseResult.value instanceof Program ?
                (Program) parseResult.value :
                null;
    }
}
