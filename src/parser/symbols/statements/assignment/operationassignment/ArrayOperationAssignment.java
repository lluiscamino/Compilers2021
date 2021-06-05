package parser.symbols.statements.assignment.operationassignment;

import main.Compiler;
import parser.symbols.ArrayIndexes;
import parser.symbols.declarations.cva.ArrayDeclaration;
import parser.symbols.declarations.cva.CVADeclaration;
import parser.symbols.expressions.Expression;
import parser.symbols.statements.assignment.ArrayAssignment;
import parser.symbols.types.PrimitiveType;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import tac.generators.TACVariableGenerator;
import tac.instructions.arithmetic.AddInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.instructions.arithmetic.ProductInstruction;
import tac.instructions.indexation.IndexAssignmentInstruction;
import tac.instructions.indexation.IndexedValueInstruction;
import tac.references.TACLiteral;
import tac.references.TACVariable;
import tac.tables.VariablesTable;

import java.util.List;

public abstract class ArrayOperationAssignment extends ArrayAssignment {
    public ArrayOperationAssignment(String identifier, ArrayIndexes indexes, Expression expression) {
        super(identifier, indexes, expression);
    }
    
    @Override
    public void validate() {
        try {
            SymbolTable symbolTable = main.Compiler.getCompiler().getSemanticAnalyzer().getSymbolTable();
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

    @Override
    public void toTac() {
        VariablesTable variablesTable = Compiler.getCompiler().getSemanticAnalyzer().getVariablesTable();
        TACVariableGenerator variableGenerator = Compiler.getCompiler().getSemanticAnalyzer().getTacVariableGenerator();

        VariablesTable.VariableInfo variableInfo = variablesTable.get(identifier);
        TACVariable variable = variableInfo.getTacVariable();
        TACVariable newVariable = variableGenerator.generate(variableInfo.getType());
        TACVariable realIndex = variableGenerator.generate(Type.getInteger());
        indexes.toTac();
        List<Expression> indexesList = indexes.getIndexes().toArrayList();
        TACVariable lastIndex = indexesList.get(indexesList.size() - 1).getTacVariable();

        addTACInstruction(new CopyInstruction(newVariable, variable));
        for (int i = 0; i < indexesList.size() - 1; i++) {
            Expression index = indexesList.get(i);
            addTACInstruction(new ProductInstruction(realIndex, index.getTacVariable(), new TACLiteral(PrimitiveType.INT.sizeInBytes())));
            addTACInstruction(new AddInstruction(realIndex, realIndex, new TACLiteral(Type.getInteger().sizeInBytes())));
            addTACInstruction(new IndexedValueInstruction(newVariable, newVariable, realIndex));
        }
        expression.toTac();
        TACVariable temp = variableGenerator.generate(Type.getInteger());
        addTACInstruction(new ProductInstruction(realIndex, lastIndex, new TACLiteral(PrimitiveType.INT.sizeInBytes())));
        addTACInstruction(new AddInstruction(realIndex, realIndex, new TACLiteral(Type.getInteger().sizeInBytes())));
        addTACInstruction(new IndexedValueInstruction(temp, newVariable, realIndex));
        operationToTac(temp);
        addTACInstruction(new IndexAssignmentInstruction(newVariable, realIndex, temp));
    }

    public abstract void operationToTac(TACVariable variable);
    
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
