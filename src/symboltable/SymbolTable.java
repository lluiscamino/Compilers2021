package symboltable;

import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.cva.CVADeclaration;

public class SymbolTable {

    private Scope scope;

    public SymbolTable() {
        this.scope = new Scope();
    }

    public boolean put(Declaration declaration) {
        return scope.put(declaration);
    }

    public Declaration get(String name) {
        return scope.get(name);
    }
    
    public CVADeclaration getCVA(String name) {
        Declaration decl = scope.get(name);
        if (decl == null || !(decl instanceof CVADeclaration)) {
            return null;
        }
        return (CVADeclaration) decl;
    }

    public void enterBlock() {
        Scope newScope = new Scope(scope);
        scope = newScope;
    }

    public void exitBlock() {
        if (scope.getPrevious() == null) {
            //gestionar el error
        }
        scope = scope.getPrevious();
    }
    
    public void clear() {
        scope = new Scope();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Scope node = scope;
        while (node != null) {
            buffer.append(node.toString());
            node = node.getPrevious();
        }
        return buffer.toString();
    }
}
