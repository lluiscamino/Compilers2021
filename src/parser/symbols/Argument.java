package parser.symbols;

import dot.DotNode;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class Argument extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARGUMENT";
    private final Type type;
    private final String identifier;

    public Argument(Type type, String identifier) {
        super(STRING_IDENTIFIER);
        this.type = type;
        this.identifier = identifier;
    }
    
    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, STRING_IDENTIFIER, "box", "filled", "");
        dotNode.addEdge(type, "type");
        dotNode.addEdge((StringBuilder buffer1) -> {
            new DotNode(buffer1, identifier, "plaintext", "", "");
        }, "ident");
    }
    
}
