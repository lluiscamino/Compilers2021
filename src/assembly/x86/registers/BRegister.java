package assembly.x86.registers;

public final class BRegister extends x86Register {
    protected BRegister() {}

    @Override
    protected String oneByteName() {
        return "%bl";
    }

    @Override
    protected String fourBytesName() {
        return "%ebx";
    }

    @Override
    protected String eightBytesName() {
        return "%rbx";
    }
}
