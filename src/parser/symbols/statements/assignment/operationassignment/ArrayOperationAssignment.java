package parser.symbols.statements.assignment.operationassignment;

import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.assignment.ArrayAssignment;
import parser.symbols.types.Type;
import symboltable.SymbolTable;

public abstract class ArrayOperationAssignment extends ArrayAssignment {
    public ArrayOperationAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, indexes, expression);
    }
    
    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = main.Compiler.getCompiler().getSymbolTable();
            CVADeclaration declaration = symbolTable.getCVA(identifier);
            checkDeclarationExists(declaration);
            checkDeclarationIsVariable(declaration);
            checkDeclarationIsArray(declaration);
            checkTypeIsInteger(declaration);
        } catch (Exception ex) {
            addSemanticError(ex.getMessage());
        } finally {
            expression.validate();
        }
    }
    
    protected void checkTypeIsInteger(CVADeclaration declaration) throws Exception {
        Type expectedType = getExpectedType((ArrayDeclaration) declaration);
        Type exprType = expression.getType();
        if (expectedType == null) {
            throw new Exception("El array " + identifier + " no tiene tantas dimensiones");
        } else if (!isIntegerOrUnknown(expectedType) || !isIntegerOrUnknown(exprType)) {
            throw new Exception("No se puede hacer una operación aritmética con un tipo que no sea " + Type.getInteger());
        }
    }
    
    protected boolean isIntegerOrUnknown(Type type) {
        return type.isInteger() || type.isUnknown();
    }
}
