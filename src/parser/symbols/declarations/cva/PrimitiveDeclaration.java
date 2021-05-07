package parser.symbols.declarations.cva;

import dot.DotNode;
import main.Compiler;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.expressions.Expression;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;


public final class PrimitiveDeclaration extends CVADeclaration {

    public PrimitiveDeclaration(DeclarationMode mode, PrimitiveType primitiveType,
            String identifier) {
        super(mode, new Type(primitiveType), identifier);
    }
    
    public PrimitiveDeclaration(DeclarationMode mode, PrimitiveType primitiveType,
            String identifier, Expression expression) {
        super(mode, new Type(primitiveType), identifier, expression);
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("DECL", "box", "filled", "#5280d6");
        
        dotNode.addEdge(mode, "mode");
        dotNode.addEdge(type, "type");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdgeIfNotNull(expression, "value");
    }

    @Override
    public void toTac() {
        SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        symbolTable.put(this);
        TACVariable variable = variableGenerator.generate(identifier, false);
        if (expression != null) {
            expression.toTac();
            addTACInstruction(new CopyInstruction(variable, expression.getTacVariable()));
        } else {
            addTACInstruction(new CopyInstruction(variable, new TACLiteral(type.getPrimitiveType().defaultValue())));
        }
    }
}
