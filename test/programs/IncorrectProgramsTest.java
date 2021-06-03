package programs;

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
                        "pero devuelve un valor de tipo BOOLEAN[]", getLocation(1)),
                new SemanticError("El tipo del argumento num. 2 en la llamada al subprograma compareArrays tiene" +
                        " que ser de tipo BOOLEAN[], no de BOOLEAN[][]", getLocation(11)),
                new SemanticError("No se puede asignar un valor de tipo INT[] a " +
                        "una variable de tipo INT[][]", getLocation(12)),
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
                new SemanticError("returnFirst no tiene un valor de retorno", getLocation(6)),
                new SemanticError("No se puede asignar un valor de tipo BOOLEAN a una variable de tipo INT", getLocation(7)),
                new SemanticError("La condición del bucle debe ser de tipo BOOLEAN, no de tipo INT", getLocation(11)),
                new SemanticError("No existe un subprograma llamado returnFirst", getLocation(12)),
                new SemanticError("Los elementos de un array tienen que ser del mismo tipo. " +
                        "Se encontró un elemento de tipo BOOLEAN en un array de INT", getLocation(14))
        };
        testProgram("inc3", expectedErrors);
    }

    @Test
    public void testMissingMain() throws Exception {
        final ProgramError[] expectedErrors = {
                new SyntaxError("No se esperaba el token EOF", null),
        };
        testProgram("missingmain", expectedErrors);
    }

    @Test
    public void testNonBooleanWhile() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("La condición del bucle debe ser de tipo BOOLEAN, no de tipo INT", getLocation(3)),
                new SemanticError("La condición del bucle debe ser de tipo BOOLEAN, no de tipo INT", getLocation(6)),
                new SemanticError("La condición del bucle debe ser de tipo BOOLEAN, no de tipo STRING", getLocation(9)),
                new SemanticError("La condición del bucle debe ser de tipo BOOLEAN, " +
                        "no de tipo BOOLEAN[]", getLocation(12))
        };
        testProgram("nonbooleanwhile", expectedErrors);
    }

    @Test
    public void testWrongTypeAssignment() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se puede asignar un valor de tipo STRING a una variable de tipo INT", getLocation(5)),
                new SemanticError("No se puede asignar un valor de tipo BOOLEAN a una variable de tipo INT", getLocation(6)),
                new SemanticError("No se puede asignar un valor de tipo INT[][] a una variable de tipo INT", getLocation(7)),
                new SemanticError("No se puede asignar un valor de tipo INT a una variable de tipo STRING", getLocation(9)),
                new SemanticError("No se puede asignar un valor de tipo BOOLEAN a una variable de tipo STRING", getLocation(10)),
                new SemanticError("No se puede asignar un valor de tipo STRING[][] a una variable de tipo STRING", getLocation(11))
        };
        testProgram("wrongtypeassignment", expectedErrors);
    }

    @Test
    public void testWrongTypesRelational() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se pueden comparar expresiones de tipo STRING", getLocation(2)),
                new SemanticError("No se pueden comparar expresiones de tipo BOOLEAN", getLocation(4)),
                new SemanticError("No se pueden comparar expresiones de tipo INT[]", getLocation(6)),
        };
        testProgram("wrongtypesrelational", expectedErrors);
    }

    @Test
    public void testWrongTypeNegative() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se puede hacer una operación aritmética con un tipo que no sea INT", getLocation(2)),
                new SemanticError("No se puede hacer una operación aritmética con un tipo que no sea INT", getLocation(3)),
                new SemanticError("No se puede hacer una operación aritmética con un tipo que no sea INT", getLocation(4)),
        };
        testProgram("wrongtypenegative", expectedErrors);
    }

    @Test
    public void testWrongTypeArithmeticOperation() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se puede hacer una operación aritmética con un tipo que no sea INT", getLocation(2)),
                new SemanticError("No se puede hacer una operación aritmética con un tipo que no sea INT", getLocation(3)),
                new SemanticError("No se puede hacer una operación aritmética con un tipo que no sea INT", getLocation(4)),
        };
        testProgram("wrongtypearithmeticoperation", expectedErrors);
    }

    @Test
    public void testWrongTypeBinaryOperation() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(2)),
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(3)),
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(4)),
        };
        testProgram("wrongtypebinaryoperation", expectedErrors);
    }

    @Test
    public void testWrongTypeNot() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(2)),
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(3)),
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(6)),
                new SemanticError("No se puede hacer una operación lógica con un tipo que no sea BOOLEAN", getLocation(7))
        };
        testProgram("wrongtypenot", expectedErrors);
    }

    @Test
    public void testRepeatedDeclaration() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("Declaración repeated ya definida", getLocation(3)),
                new SemanticError("Declaración repeated ya definida", getLocation(7)),
                new SemanticError("Declaración repeated ya definida", getLocation(11)),
                new SemanticError("Declaración repeated ya definida", getLocation(15))
        };
        testProgram("repeateddeclaration", expectedErrors);
    }

    @Test
    public void testProcedureReturnValue() throws Exception {
        final ProgramError[] expectedErrors = {
                new SemanticError("doNothing no tiene un valor de retorno", getLocation(10)),
                new SemanticError("doSomething no tiene un valor de retorno", getLocation(11)),
        };
        testProgram("procedurereturnvalue", expectedErrors);
    }

    private Location getLocation(final int line) {
        return new Location(line, 0);
    }

    private void testProgram(final String programName, final ProgramError[] expectedErrors) throws Exception {
        final String programPath = "test/programs/incorrectsources/" + programName;
        Compiler compiler = new Compiler(programPath);
        compiler.compile(null, null, null, null, null, null, null, null, false);
        List<ProgramError> programErrors = Compiler.getCompiler().getErrorsList();
        assert programErrors.size() == expectedErrors.length;
        for (int i = 0; i < expectedErrors.length; i++) {
            assert programErrors.get(i).equals(expectedErrors[i]);
        }
    }
}
