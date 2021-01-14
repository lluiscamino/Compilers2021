package symboltable;

import parser.symbols.declarations.Declaration;
public class Identifier {

    private final Declaration declaration;
    private final Scope scope;

    public Identifier(Declaration declaration, Scope scope) {
        this.declaration = declaration;
        this.scope = scope;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public Scope getScope() {
        return scope;
    }
}
