package parser.symbols.statements.io;

import dot.DotNode;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;

public final class Read extends Statement {
    
    private final String identifier;
    
    public Read(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void toDot(StringBuilder buffer) {
        DotNode dotNode = new DotNode(buffer, "READ", "", "filled", "#00a2ff");
        dotNode.addEdge((StringBuilder buffer1) -> {
            DotNode dotNode1 = new DotNode(buffer1, identifier, "plaintext", "filled", "");
        }, "ident");
    }
    
}
