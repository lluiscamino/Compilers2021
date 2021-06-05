package assembly.x86.registers;

public final class CRegister extends x86Register {
    protected CRegister() {}

    @Override
    protected String oneByteName() {
        return "%cl";
    }

    @Override
    protected String fourBytesName() {
        return "%ecx";
    }

    @Override
    protected String eightBytesName() {
        return "%rcx";
    }
}
