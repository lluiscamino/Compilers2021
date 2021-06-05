package symboltable;

import parser.symbols.declarations.Declaration;
import tac.references.TACSubprogram;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Scope {

    private final Map<String, Identifier> map;
    private final Scope previous;
    private final int indentation;
    private final int number;
    private final TACSubprogram tacSubprogram;

    public Scope() {
        this.map = new HashMap<>();
        this.previous = null;
        this.indentation = 0;
        this.number = 0;
        this.tacSubprogram = null;
    }

    public Scope(Scope previous, int indentation) {
        this.map = new HashMap<>();
        this.previous = previous;
        this.indentation = indentation;
        this.number = previous.number + 1;
        this.tacSubprogram = null;
    }

    public Scope(Scope previous, int indentation, TACSubprogram tacSubprogram) {
        this.map = new HashMap<>();
        this.previous = previous;
        this.indentation = indentation;
        this.number = previous.number + 1;
        this.tacSubprogram = tacSubprogram;
    }

    public Scope getPrevious() {
        return previous;
    }

    public int getIndentation() {
        return indentation;
    }
    
    public Collection<Identifier> getIdentifiers() {
        return map.values();
    }

    public TACSubprogram getTacSubprogram() {
        return tacSubprogram;
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

    private Identifier getIdentifier(String identifierName) {
        Identifier identifier = map.get(identifierName);
        if (identifier != null || previous == null) {
            return identifier;
        }
        return previous.getIdentifier(identifierName);
    }

}
