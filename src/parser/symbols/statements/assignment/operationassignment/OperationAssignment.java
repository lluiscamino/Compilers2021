package parser.symbols.statements.assignment.operationassignment;

import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.assignment.Assignment;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public abstract class OperationAssignment extends Assignment {
    public OperationAssignment(String identifier, Expression expression) {
        super(identifier, expression);
    }
    
    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = main.Compiler.getCompiler().getSymbolTable();
            CVADeclaration declaration = symbolTable.getCVA(identifier);
            checkDeclarationExists(declaration);
            checkDeclarationIsVariable(declaration);
            checkTypeIsInteger(declaration);
        } catch (Exception ex) {
            addSemanticError(ex.getMessage());
        } finally {
            expression.validate();
        }
    }
    
    protected void checkTypeIsInteger(CVADeclaration declaration) throws Exception {
        Type declType = declaration.getType();
        Type exprType = expression.getType();
        if (!isIntegerOrUnknown(declType) || !isIntegerOrUnknown(exprType)) {
            throw new Exception("No se puede hacer una operación aritmética con un tipo que no sea " + Type.getInteger());
        }
    }
    
    protected boolean isIntegerOrUnknown(Type type) {
        return type.isInteger() || type.isUnknown();
    }
}
