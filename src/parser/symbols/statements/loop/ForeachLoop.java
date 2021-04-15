package parser.symbols.statements.loop;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
