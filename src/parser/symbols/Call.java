package parser.symbols;

import dot.DotNode;
import java.util.ArrayList;
import java.util.List;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.subprogram.SubprogramDeclaration;
import parser.symbols.expressions.*;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public final class Call extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "CALL";
    
    private final String subProgramIdentifier;
    private final SymbolList<Expression> arguments;
    
    public Call(String subProgramIdentifier, SymbolList<Expression> arguments) {
        super(STRING_IDENTIFIER);
        this.subProgramIdentifier = subProgramIdentifier;
        this.arguments = arguments;
    }
    
    public Type getReturnType() {
        // TODO: Consultar tabla de símbolos
        return null;
    }

    @Override
    public void validate(SymbolTable symbolTable) {
        //buscar el identificador en la tabla de simbolos
        Declaration decl = symbolTable.get(subProgramIdentifier);
        if (decl == null) {
            this.addSemanticError("No existe un subprograma llamado " + this.subProgramIdentifier);
            return;
        }
        if (!(decl instanceof SubprogramDeclaration)) {
            this.addSemanticError("El identificar " + this.subProgramIdentifier + " no pertenece a un subprograma.");
            return;
        }
        //mirar si los tipos de argumentos coinciden
        SubprogramDeclaration subpDecl = (SubprogramDeclaration) decl;
        
        List<Expression> actualArgs = arguments != null ? arguments.toArrayList() : new ArrayList<>();
        List<Argument> args = subpDecl.toArrayListArguments();
        
        //comparar la cantidad de argumentos
        if (actualArgs.size() != args.size()) {
            this.addSemanticError("Cantidad de argumentos incorrecta en la llamada al subprograma " + subProgramIdentifier);
            return;
        }
        
        //comparar los tipos de argumentos
        for (int i = 0; i < actualArgs.size(); i++) {
            Type expectedType = args.get(i).getType();
            Type actualType = actualArgs.get(i).getType();
            if (!actualType.equals(expectedType)) {
                this.addSemanticError("El tipo del argumento num. " + (i + 1) + " en la llamada al subprograma " 
                        + subProgramIdentifier + " tiene que ser de tipo " + expectedType + ", no de " + actualType);
            }
        }
        
        if (arguments != null) {
            arguments.validate(symbolTable);
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("CALL", "", "filled", "#00a2ff");
        
        dotNode.addEdge(() -> {
            new DotNode(subProgramIdentifier, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(arguments, "args");
    }
    
}
