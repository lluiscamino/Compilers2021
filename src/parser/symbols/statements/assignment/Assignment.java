package parser.symbols.statements.assignment;

import dot.DotNode;
import main.Compiler;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.Statement;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

public class Assignment extends Statement {

    protected final String identifier;
    protected final Expression expression;

    public Assignment(String identifier, Expression expression) {
        super(expression.xleft);
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
            CVADeclaration declaration = symbolTable.getCVA(identifier);
            checkDeclarationExists(declaration);
            checkDeclarationIsVariable(declaration);
            checkTypesAreEqual(declaration);
        } catch (Exception ex) {
            addSemanticError(ex.getMessage());
        } finally {
            expression.validate();
        }
    }
    
    protected void checkDeclarationExists(CVADeclaration declaration) throws Exception {
        if (declaration == null) {
            throw new Exception("No existe ninguna variable llamada " + identifier);
        }
    }
    
    protected void checkDeclarationIsVariable(CVADeclaration declaration) throws Exception {
        if (declaration.getMode().isConstant()) {
            throw new Exception(identifier + " es constante, no se puede variar su valor");
        }
    }
    
    protected void checkTypesAreEqual(CVADeclaration declaration) throws Exception {
        Type declType = declaration.getType();
        Type exprType = expression.getType();
        boolean unknownType = declType.isUnknown() || exprType.isUnknown();
        if (!unknownType && !declType.equals(exprType)) {
            throw new Exception("No se puede asignar un valor de tipo " + exprType + " a una variable de tipo " + declaration.getType());
        }
    }

    @Override
    public void toDot() {
        DotNode dotNode = new DotNode("ASSGN", "", "filled", "#5280d6");
        dotNode.addEdge(() -> {
            new DotNode(identifier, "plaintext", "filled", "");
        }, "ident");
        dotNode.addEdge(expression, "expr");
    }

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        TACVariable variable = variablesTable.get(identifier).getTacVariable();
        expression.toTac();
        addTACInstruction(new CopyInstruction(variable, expression.getTacVariable()));
    }
}
