package parser.symbols.expressions.reference;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import main.Compiler;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.tables.VariablesTable;

public class IdentifierReference extends Expression {

    protected final String identifierName;

    public IdentifierReference(String identifierName, Location location) {
        super(Type.getUnknown(), Mode.UNKNOWN, location);
        this.identifierName = identifierName;
    }
    
    @Override
    public Type getType() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        return decl != null ? decl.getType(): Type.getUnknown();
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        //mirar la tabla de simbolos
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (decl == null) {
            addSemanticError("No existe ninguna variable llamada " + identifierName);
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IDENT", "box", "filled", "#BADA55");
        
        dotNode.addEdge(() -> new DotNode(identifierName, "plaintext", "", ""), "ident");
    }

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        tacVariable = variablesTable.get(identifierName).getTacVariable();
    }
}
