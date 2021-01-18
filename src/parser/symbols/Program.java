package parser.symbols;

import dot.DotNode;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.subprogram.MainDeclaration;
import symboltable.SymbolTable;
import main.Compiler;

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
        if (declarations != null) {
            SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
            for (Declaration decl : declarations.toArrayList()) {
                if (!symbolTable.put(decl)) {
                    addSemanticError("Declaración " + decl.getIdentifier() + " ya definida");
                }
            }
            declarations.validate();
        }
        main.validate();
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode(STRING_IDENTIFIER, "box", "filled", "#0000ff");
        
        dotNode.addEdgeIfNotNull(declarations);
        dotNode.addEdge(main);
    }
}
