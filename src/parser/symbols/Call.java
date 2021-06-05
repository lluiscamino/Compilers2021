package parser.symbols;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import main.Compiler;
import parser.symbols.declarations.subprogram.FunctionDeclaration;
import parser.symbols.declarations.subprogram.SubprogramDeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.instructions.subprogram.ParameterInstruction;

import java.util.ArrayList;
import java.util.List;

public final class Call extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "CALL";
    
    private final String subProgramIdentifier;
    private final SymbolList<Expression> arguments;
    
    public Call(String subProgramIdentifier, SymbolList<Expression> arguments, Location location) {
        super(STRING_IDENTIFIER, location);
        this.subProgramIdentifier = subProgramIdentifier;
        this.arguments = arguments;
    }

    public String getSubProgramIdentifier() {
        return subProgramIdentifier;
    }

    public Type getReturnType() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        SubprogramDeclaration decl = symbolTable.getSubprogram(subProgramIdentifier);
        
        if (decl == null) {
            return Type.getUnknown();
        }
        if (decl instanceof FunctionDeclaration) {
            return  ((FunctionDeclaration) decl).getReturnType();
        }
        return Type.getUnknown();
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        //buscar el identificador en la tabla de simbolos
        SubprogramDeclaration decl = symbolTable.getSubprogram(subProgramIdentifier);
        if (decl == null) {
            this.addSemanticError("No existe un subprograma llamado " + this.subProgramIdentifier);
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
            if (!actualType.isUnknown() && !actualType.equals(expectedType)) {
                this.addSemanticError("El tipo del argumento num. " + (i + 1) + " en la llamada al subprograma " 
                        + subProgramIdentifier + " tiene que ser de tipo " + expectedType + ", no de " + actualType);
            }
        }
        
        if (arguments != null) {
            arguments.validate();
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("CALL", "box", "filled", "#dbae91");
        
        dotNode.addEdge(() -> {
            new DotNode(subProgramIdentifier, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(arguments, "args");
    }

    @Override
    public void toTac() {
        List<Expression> argumentsList = arguments != null ? arguments.toArrayList() : new ArrayList<>();
        for (int i = argumentsList.size() - 1; i >= 0; i--) {
            argumentsList.get(i).toTac();
        }
        for (int i = argumentsList.size() - 1; i >= 0; i--) {
            addTACInstruction(new ParameterInstruction(argumentsList.get(i).getTacVariable()));
        }
    }
}
