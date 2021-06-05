package assembly.x86.registers;

public final class x86RegisterFactory {
    public x86Register getRegister(String name) {
        return switch (name) {
            case "a" -> x86Register.A;
            case "b" -> x86Register.B;
            case "c" -> x86Register.C;
            case "d" -> x86Register.D;
            default -> throw new RuntimeException("Invalid register name " + name + ". Valid options: a, b, c and d");
        };
    }
}
