package tac.instructions.io.print;

import parser.symbols.expressions.Expression;
import parser.symbols.types.Type;
import tac.references.TACReference;

public final class PrintInstructionFactory {
    public PrintInstruction get(Expression expression) {
        Type type = expression.getType();
        TACReference reference = expression.getTacVariable();

        if (type.isArray()) {
            return new PrintArrayInstruction(reference);
        }
        return switch (type.getPrimitiveType()) {
            case INT, UNKNOWN -> new PrintIntInstruction(reference);
            case BOOLEAN -> new PrintBooleanInstruction(reference);
            case STRING -> new PrintStringInstruction(reference);
        };
    }
}
