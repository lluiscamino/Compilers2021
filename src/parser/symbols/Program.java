package parser.symbols;

import java.util.List;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.subprogram.MainDeclaration;

public final class Program {
    private final List<Declaration> declarations;
    private final MainDeclaration main;

    public Program(List<Declaration> declarations, MainDeclaration main) {
        this.declarations = declarations;
        this.main = main;
    }
}
