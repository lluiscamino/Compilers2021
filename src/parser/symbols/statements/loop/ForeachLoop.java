package parser.symbols.statements.loop;

import analyzers.SemanticAnalyzer;
import dot.DotNode;
import parser.symbols.SymbolList;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import symboltable.SymbolTable;
import main.Compiler;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.MockExpression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import tac.generators.TACTagGenerator;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.instructions.bifurcation.GotoInstruction;
import tac.instructions.bifurcation.SkipInstruction;
import tac.instructions.bifurcation.ifs.IfEqual;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACTag;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public class ForeachLoop extends Loop {

    private final CVADeclaration declaration;
    private final Expression array;

    public ForeachLoop(CVADeclaration declaration, Expression array, SymbolList<Statement> statements) {
        super(array, statements);
        this.declaration = declaration;
        this.array = array;
    }

    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        try {
            //mirar que el objeto a iterar sea un array
            if (!array.getType().isArray()) {
                addSemanticError("La expresión a iterar debe ser de tipo ARRAY.");
                return;
            }
            if (declaration.hasAssociatedValue()) {
                addSemanticError("La declaración en un bucle FOREACH no puede tener un valor asociado");
                return;
            }
            Type declType = declaration.getType();

            //mirar si el tipo de la declaracion corresponde con el tipo del array
            Type expectedType = getExpectedDeclarationType();
            String declMode = declaration.getMode().isConstant() ? "constante" : "variable";
            if (!declType.isUnknown() && !expectedType.isUnknown() && !declType.equals(expectedType)) {
                addSemanticError("No se puede asignar un valor de tipo " + expectedType + " a una " + declMode + " de tipo " + declType);
            }
        } finally {
            symbolTable.enterBlock();
            declaration.setAssociatedValue(new MockExpression(declaration.xleft));
            declaration.validate();
            array.validate();
            if (statements != null) {
                statements.validate();
            }
            symbolTable.exitBlock();
        }
    }
    
    private Type getExpectedDeclarationType() {
        Type type = array.getType();
        PrimitiveType primType = type.getPrimitiveType();
        int numDimensions = type.getDimensions().size();
        return Type.getArray(primType, numDimensions - 1);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("FOREACH", "box", "filled", "#5280d6");
        declaration.setAssociatedValue(null);
        dotNode.addEdgeIfNotNull(declaration, "decl");
        dotNode.addEdge(array, "array");
        dotNode.addEdgeIfNotNull(statements, "stmts");
    }

    @Override
    public void toTac() {
        SemanticAnalyzer semanticAnalyzer = Compiler.getCompiler().getSemanticAnalyzer();
        SymbolTable symbolTable = semanticAnalyzer.getSymbolTable();
        VariablesTable variablesTable = semanticAnalyzer.getVariablesTable();
        TACVariableGenerator variableGenerator = semanticAnalyzer.getTacVariableGenerator();
        TACTagGenerator tagGenerator = semanticAnalyzer.getTacTagGenerator();

        symbolTable.enterBlock();
        array.toTac();
        TACVariable index = variableGenerator.generate(Type.getInteger());
        TACVariable realIndex = variableGenerator.generate(Type.getInteger());
        addTACInstruction(new CopyInstruction(index, new TACLiteral(0)));
        TACVariable arrayLength = variableGenerator.generate(Type.getInteger());
        addTACInstruction(new IndexedValueInstruction(arrayLength, array.getTacVariable(), new TACLiteral(0)));
        declaration.toTac();
        TACVariable arrayItemVariable = variablesTable.get(declaration.getIdentifier()).getTacVariable();

        TACTag startTag = tagGenerator.generate(), endTag = tagGenerator.generate();

        addTACInstruction(new SkipInstruction(startTag));
        addTACInstruction(new IfEqual(index, arrayLength, endTag));
        addTACInstruction(new AddInstruction(realIndex, index, new TACLiteral(1)));
        addTACInstruction(new ProductInstruction(realIndex, realIndex, new TACLiteral(PrimitiveType.INT.sizeInBytes())));
        addTACInstruction(new IndexedValueInstruction(arrayItemVariable, array.getTacVariable(), realIndex));
        if (statements != null) {
            statements.toTac();
        }
        addTACInstruction(new AddInstruction(index, index, new TACLiteral(1)));
        symbolTable.exitBlock();
        addTACInstruction(new GotoInstruction(startTag));
        addTACInstruction(new SkipInstruction(endTag));
    }
}
