package parser.symbols;

import dot.DotNode;
import main.Compiler;
import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.declarations.cva.PrimitiveDeclaration;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.generators.TACVariableGenerator;

public final class Argument extends ParserSymbol {
    private static final String STRING_IDENTIFIER = "ARGUMENT";
    private final Type type;
    private final String identifier;

    public Argument(Type type, String identifier) {
        super(STRING_IDENTIFIER, type.xleft);
        this.type = type;
        this.identifier = identifier;
    }
    
    public Type getType() {
        return this.type;
    }
    
    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        DeclarationMode declMode = DeclarationMode.getVariable(type.xleft);
        Declaration declaration = type.isArray() ?
                new ArrayDeclaration(declMode, type.getPrimitiveType(), type.getDimensions(), identifier) :
                new PrimitiveDeclaration(declMode, type.getPrimitiveType(), identifier);
        if (!symbolTable.put(declaration)) {
            addSemanticError("Variable " + identifier + " ya definida");
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode(STRING_IDENTIFIER, "box", "filled", "#F1F1F1");
        dotNode.addEdge(type, "type");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "", "");
        }, "ident");
    }

    @Override
    public void toTac() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        DeclarationMode declMode = DeclarationMode.getVariable(type.xleft);
        Declaration declaration = type.isArray() ?
                new ArrayDeclaration(declMode, type.getPrimitiveType(), type.getDimensions(), identifier) :
                new PrimitiveDeclaration(declMode, type.getPrimitiveType(), identifier);
        symbolTable.put(declaration);

        variableGenerator.generate(identifier, type, true);
    }
}
