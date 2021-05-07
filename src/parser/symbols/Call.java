package parser.symbols;

import dot.DotNode;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.declarations.subprogram.SubprogramDeclaration;
import parser.symbols.expressions.*;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;
import parser.symbols.declarations.subprogram.FunctionDeclaration;
import tac.instructions.subprogram.CallInstruction;
import tac.instructions.subprogram.SimpleParameterInstruction;
import tac.references.TACSubprogram;
import tac.tables.SubprogramsTable;

public final class Call extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "CALL";
    
    private final String subProgramIdentifier;
    private final SymbolList<Expression> arguments;
    
    public Call(String subProgramIdentifier, SymbolList<Expression> arguments, Location location) {
        super(STRING_IDENTIFIER, location);
        this.subProgramIdentifier = subProgramIdentifier;
        this.arguments = arguments;
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
        SubprogramsTable subprogramsTable = Compiler.getCompiler().getSemanticAnalyzer().getSubprogramsTable();
        List<Expression> argumentsList = arguments != null ? arguments.toArrayList() : new ArrayList<>();
        for (Expression expression : argumentsList) {
            expression.toTac();
            addTACInstruction(new SimpleParameterInstruction(expression.getTacVariable()));
        }
        TACSubprogram subprogram = subprogramsTable.get(subProgramIdentifier).getTacSubprogram();
        addTACInstruction(new CallInstruction(subprogram));
    }
}
