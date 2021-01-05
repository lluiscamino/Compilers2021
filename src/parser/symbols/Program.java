package parser.symbols;

import dot.DotNode;
import java.io.PrintWriter;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.subprogram.MainDeclaration;

public final class Program extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "PROGRAM";
    
    private final SymbolList<Declaration> declarations;
    private final MainDeclaration main;

    public Program(SymbolList<Declaration> declarations, MainDeclaration main) {
        super(STRING_IDENTIFIER);
        this.declarations = declarations;
        this.main = main;
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(PrintWriter out) {
        DotNode dotNode = new DotNode(this, STRING_IDENTIFIER, "box", "filled", "#0000ff");
        
        dotNode.addEdge(main);
        dotNode.addEdge(declarations);
        
        dotNode.print(out);
        
        main.toDot(out);
        declarations.toDot(out);
    }
}