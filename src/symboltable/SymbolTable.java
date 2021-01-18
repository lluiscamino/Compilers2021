package symboltable;

import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.declarations.subprogram.SubprogramDeclaration;

public class SymbolTable {

    private final Scope initialScope;
    private Scope scope;

    public SymbolTable() {
        initialScope = new Scope();
        scope = initialScope;
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
    
    public SubprogramDeclaration getSubprogram(String name) {
        Declaration decl = scope.get(name);
        if (decl == null || !(decl instanceof SubprogramDeclaration)) {
            return null;
        }
        return (SubprogramDeclaration) decl;
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
    
    public boolean isInInitialScope() {
        return scope == initialScope;
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
