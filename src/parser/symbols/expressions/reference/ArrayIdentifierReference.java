package parser.symbols.expressions.reference;

import dot.DotNode;
import java_cup.runtime.ComplexSymbolFactory.Location;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import symboltable.SymbolTable;
import main.Compiler;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public final class ArrayIdentifierReference extends IdentifierReference {
    private final ArrayIndexes indexes;

    public ArrayIdentifierReference(String identifierName, ArrayIndexes indexes, Location location) {
        super(identifierName, location);
        this.indexes = indexes;
    }

    @Override
    public Type getType() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        CVADeclaration decl = symbolTable.getCVA(identifierName);
        if (!(decl instanceof ArrayDeclaration)) {
            return Type.getUnknown();
        }
        ArrayDeclaration arrDecl = (ArrayDeclaration) decl;
        int numIndexes = indexes.numIndexes();
        int numArrayDimensions = arrDecl.getDimensions().size();
        if (numIndexes > numArrayDimensions) {
            return Type.getUnknown();
        }
        int numDimensions = numArrayDimensions - numIndexes;
        PrimitiveType primType = arrDecl.getType().getPrimitiveType();
        return Type.getArray(primType, numDimensions);
    }

    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
            CVADeclaration decl = symbolTable.getCVA(identifierName);
            if (decl == null) {
                addSemanticError("No existe ninguna variable llamada " + identifierName);
                return;
            }
            if (!(decl instanceof ArrayDeclaration)) {
                addSemanticError(identifierName + " no es un array");
                return;
            }
            ArrayDeclaration arrDecl = (ArrayDeclaration) decl;
            int numIndexes = indexes.numIndexes();
            int numArrayDimensions = arrDecl.getDimensions().size();
            if (numIndexes > numArrayDimensions) {
                addSemanticError("El array " + identifierName + " no tiene tantas dimensiones");
            }
        } finally {
            indexes.validate();
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("IDENT_ARR", "box", "filled", "#afd92b");

        dotNode.addEdge(() -> {
            new DotNode(identifierName, "plaintext", "", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(indexes, "indexes");
    }

    @Override
    public void toTac() {
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();

        TACVariable identifierVariable = variablesTable.get(identifierName).getTacVariable();
        for (Expression index : indexes.getIndexes().toArrayList()) {
            index.toTac();
            tacVariable = variableGenerator.generate();
            TACVariable indexVariable = index.getTacVariable();
            addTACInstruction(new AddInstruction(indexVariable, indexVariable, new TACLiteral(1)));
            addTACInstruction(new IndexedValueInstruction(tacVariable, identifierVariable, indexVariable));
            identifierVariable = tacVariable;
        }
    }
}
