package assembly.x86.registers;

public final class ARegister extends x86Register {
    protected ARegister() {}

    @Override
    protected String oneByteName() {
        return "%al";
    }

    @Override
    protected String fourBytesName() {
        return "%eax";
    }

    @Override
    protected String eightBytesName() {
        return "%rax";
    }
}
