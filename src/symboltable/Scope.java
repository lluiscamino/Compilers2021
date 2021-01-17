package symboltable;

import java.util.HashMap;
import java.util.Map;
import parser.symbols.declarations.Declaration;

public class Scope {

    private final Map<String, Identifier> map;
    private final Scope previous;
    private final int number;

    public Scope() {
        this.map = new HashMap<>();
        this.previous = null;
        this.number = 0;
    }

    public Scope(Scope previous) {
        this.previous = previous;
        this.number = previous.number + 1;
        this.map = new HashMap<>();
    }

    public Scope getPrevious() {
        return previous;
    }

    public int getNumber() {
        return number;
    }

    public boolean put(Declaration declaration) {
        String name = declaration.getIdentifier();
        Identifier identifier = getIdentifier(name);
        if (identifier != null) {
            if (this.equals(identifier.getScope()))   {
                return false;
            }
        }
        map.put(name, new Identifier(declaration, this));
        return true;
    }

    public Declaration get(String name) {
        Identifier identifier = getIdentifier(name);
        if (identifier != null) {
            return identifier.getDeclaration();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Identifier identifier : map.values()) {
            buffer.append(identifier.getDeclaration().getName()).append(" ");
        }
        buffer.append("\n");
        return buffer.toString();
    }

    private Identifier getIdentifier(String identifierName) {
        Identifier identifier = map.get(identifierName);
        if (identifier != null || previous == null) {
            return identifier;
        }
        return previous.getIdentifier(identifierName);
    }

}
