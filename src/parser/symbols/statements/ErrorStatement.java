package parser.symbols.statements;

import errors.ProgramError;
import errors.SyntaxError;
import java.util.List;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import main.Compiler;
import parser.ParserSym;

public final class ErrorStatement extends Statement {
    private final Symbol token;
    
    public ErrorStatement(Symbol token, Location location) {
        super(location);
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
    public void toDot() {}

    @Override
    public void toTac() {}
}
