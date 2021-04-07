import errors.ProgramError;
import errors.SemanticError;
import errors.SyntaxError;
import java_cup.runtime.ComplexSymbolFactory.Location;
import main.Compiler;
import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

public final class IncorrectProgramsTest {

    @Test
    public void testProgram1() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se pueden comparar tipos diferentes (BOOLEAN y STRING)", getLocation(3)),
                new SemanticError("No se puede asignar un valor de tipo BOOLEAN a una variable de tipo INT", getLocation(17)),
                new SemanticError("Cantidad de argumentos incorrecta en la llamada al subprograma incorrectCompare", getLocation(17)),
                new SyntaxError("No se esperaba el token EOL", getLocation(19)),
                new SyntaxError("No se esperaba el token IDENT", getLocation(20))
        };
        testProgram("inc1", expectedErrors);
    }

    @Test
    public void testProgram2() throws Exception {
        final ProgramError[] expectedErrors = {
                new SyntaxError("No se esperaba el token EQUALS", getLocation(2)),
                new SemanticError("La función compareArrays debería devolver un tipo INT " +
                        "pero devuelve un valor de tipo BOOLEAN_ARR Dimensions:1", getLocation(1)),
                new SemanticError("El tipo del argumento num. 2 en la llamada al subprograma compareArrays tiene" +
                        " que ser de tipo BOOLEAN_ARR Dimensions:1, no de BOOLEAN_ARR Dimensions:2", getLocation(11)),
                new SemanticError("No se puede asignar un valor de tipo INT_ARR Dimensions:1 a " +
                        "una variable de tipo INT_ARR Dimensions:2", getLocation(12)),
                new SemanticError("i ya ha sido definido previamente", getLocation(13)),
                new SyntaxError("No se esperaba el token R_BRK", getLocation(15))
        };
        testProgram("inc2", expectedErrors);
    }

    @Test
    public void testProgram3() throws Exception {
        final ProgramError[] expectedErrors = {
                new SyntaxError("No se esperaba el token L_PAR", getLocation(1)),
                new SyntaxError("No se esperaba el token PRIM_TYPE", getLocation(5)),
                new SemanticError("No existe ninguna variable llamada i", getLocation(6)),
                new SemanticError("No existe un subprograma llamado returnFirst", getLocation(6)),
                new SemanticError("No se puede asignar un valor de tipo BOOLEAN a una variable de tipo INT", getLocation(7)),
                new SemanticError("La condición del bucle debe ser de tipo BOOLEAN, no de tipo INT", getLocation(11)),
                new SemanticError("No existe un subprograma llamado returnFirst", getLocation(12)),
                new SemanticError("Los elementos de un array tienen que ser del mismo tipo. " +
                        "Se encontró un elemento de tipo BOOLEAN en un array de INT", getLocation(14))
        };
        testProgram("inc3", expectedErrors);
    }

    private Location getLocation(int line) {
        return new Location(line, 0);
    }

    private void testProgram(final String programName, final ProgramError[] expectedErrors) throws Exception {
        final String programPath = "test/incorrectsources/" + programName;
        final StringWriter
                tokensWriter = new StringWriter(),
                symbolTableWriter = new StringWriter(),
                treeWriter = new StringWriter(),
                errorsWriter = new StringWriter();
        Compiler compiler = new Compiler(programPath, tokensWriter, symbolTableWriter, treeWriter, errorsWriter);
        compiler.compile();
        List<ProgramError> programErrors = Compiler.getCompiler().getErrorsList();
        assert programErrors.size() == expectedErrors.length;
        for (int i = 0; i < expectedErrors.length; i++) {
            assert programErrors.get(i).equals(expectedErrors[i]);
        }
    }
}
