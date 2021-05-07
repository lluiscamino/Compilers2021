package parser.symbols.expressions;

import errors.ProgramError;
import errors.SyntaxError;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import parser.symbols.expressions.Expression.Mode;
import main.Compiler;
import parser.ParserSym;
import parser.symbols.types.Type;

public final class ErrorExpression extends Expression {
    private final Symbol token;
    
    public ErrorExpression(Symbol token, Location location) {
        super(Type.getUnknown(), Mode.UNKNOWN, location);
        this.token = token;
    }

    @Override
    public void validate() {
        List<ProgramError> errorsList = Compiler.getCompiler().getErrorsList();
        SyntaxError error;
        if (token != null) {
            String tokenName = ParserSym.terminalNames[token.sym];
            error = new SyntaxError("No se esperaba el token " + tokenName, xleft);
        } else {
            error = new SyntaxError("Error en la declaración", xleft);
        }
        errorsList.add(error);
    }

    @Override
    public void toDot() {
    }

    @Override
    public void toTac() {
    }
}
