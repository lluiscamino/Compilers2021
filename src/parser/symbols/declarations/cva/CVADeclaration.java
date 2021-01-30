package parser.symbols.declarations.cva;

import parser.symbols.declarations.Declaration;
import parser.symbols.declarations.DeclarationMode;
import parser.symbols.types.Type;
import symboltable.SymbolTable;
import main.Compiler;
import parser.symbols.expressions.Expression;

public abstract class CVADeclaration extends Declaration {
    protected final Type type;
    protected final DeclarationMode mode;
    protected Expression expression;
    
    public CVADeclaration(DeclarationMode mode, Type type, String identifier) {
        super(identifier, mode.xleft);
        this.mode = mode;
        this.type = type;
        this.expression = null;
    }

    public CVADeclaration(DeclarationMode mode, Type type, String identifier, Expression expression) {
        super(identifier, mode.xleft);
        this.mode = mode;
        this.type = type;
        this.expression = expression;
    }

    public Type getType() {
        return type;
    }

    public DeclarationMode getMode() {
        return mode;
    }
    
    public boolean hasAssociatedValue() {
        return expression != null;
    }
    
    public void setAssociatedValue(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public void validate() {
        SymbolTable symbolTable = Compiler.getCompiler().getSymbolTable();
        if (mode.isConstant() && expression == null) {
            addSemanticError("La declaración de la constante " + identifier + " no tiene ningun valor asociado");
        }
        if (expression != null) {
            Type exprType = expression.getType();
            if (!type.isUnknown() && !exprType.isUnknown() && !type.equals(exprType)) {
                addSemanticError("No se puede asignar un valor de tipo " + exprType + " a una variable de tipo " + type);
            }
            expression.validate();
        }
        if (!symbolTable.isInInitialScope() && !symbolTable.put(this)) {
            addSemanticError(identifier + " ya ha sido definido previamente");
        }
    }
    
    @Override
    public String toString() {
        int lineNum = xleft != null ? xleft.getLine() : -1;
        return lineNum + ": " + mode + " " + type + " " + identifier;
    }
}
