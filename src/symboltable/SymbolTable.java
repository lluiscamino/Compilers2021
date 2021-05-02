package symboltable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.declarations.subprogram.SubprogramDeclaration;

public class SymbolTable {

    private final List<Scope> scopes;
    private int indentLevel;

    private Scope initialScope;
    private Scope scope;

    public SymbolTable() {
        scopes = new ArrayList<>();
        indentLevel = 0;
        initialScope = new Scope();
        scope = initialScope;
        scopes.add(scope);
    }

    public Scope getScope() {
        return scope;
    }

    public boolean put(Declaration declaration) {
        return scope.put(declaration);
    }

    public Declaration get(String name) {
        return scope.get(name);
    }

    public CVADeclaration getCVA(String name) {
        Declaration decl = scope.get(name);
        if (!(decl instanceof CVADeclaration)) {
            return null;
        }
        return (CVADeclaration) decl;
    }

    public SubprogramDeclaration getSubprogram(String name) {
        Declaration decl = scope.get(name);
        if (!(decl instanceof SubprogramDeclaration)) {
            return null;
        }
        return (SubprogramDeclaration) decl;
    }

    public void enterBlock() {
        Scope newScope = new Scope(scope, ++indentLevel);
        scopes.add(newScope);
        scope = newScope;
    }

    public void exitBlock() {
        if (scope.getPrevious() == null) {
            throw new RuntimeException("Cannot exit initial scope");
        }
        indentLevel--;
        scope = scope.getPrevious();
    }

    public boolean isInInitialScope() {
        return scope == initialScope;
    }

    public void clear() {
        scopes.clear();
        indentLevel = 0;
        initialScope = new Scope();
        scope = initialScope;
        scopes.add(scope);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        List<Identifier> identifiers = getSortedIdentifiers();
        for (Identifier ident : identifiers) {
            int indentLevel = ident.getScope().getIndentation();
            String tabs = String.join("", Collections.nCopies(indentLevel, "\t"));
            buffer.append(tabs).append(ident.getDeclaration().toString()).append("\n");
        }
        return buffer.toString();
    }

    private List<Identifier> getSortedIdentifiers() {
        List<Identifier> identifiers = new ArrayList<>();
        for (Scope scope : scopes) {
            identifiers.addAll(scope.getIdentifiers());
        }
        Collections.sort(identifiers, new IdentifierPositionComparator());
        return identifiers;
    }

    private static class IdentifierPositionComparator implements Comparator<Identifier> {

        @Override
        public int compare(Identifier o1, Identifier o2) {
            if (locationsNotDefined(o1, o2)) {
                return 0;
            }
            int lineDiff = lineNumberDifference(o1, o2);
            return lineDiff != 0 ? lineDiff : columnNumberDifference(o1, o2);
        }

        private boolean locationsNotDefined(Identifier o1, Identifier o2) {
            return o1.getDeclaration().xleft == null || o2.getDeclaration().xleft == null;
        }

        private int lineNumberDifference(Identifier o1, Identifier o2) {
            int lineNum1 = o1.getDeclaration().xleft.getLine();
            int lineNum2 = o2.getDeclaration().xleft.getLine();
            return lineNum1 - lineNum2;
        }

        private int columnNumberDifference(Identifier o1, Identifier o2) {
            int colNum1 = o1.getDeclaration().xleft.getColumn();
            int colNum2 = o2.getDeclaration().xleft.getColumn();
            return colNum1 - colNum2;
        }
    }
}
