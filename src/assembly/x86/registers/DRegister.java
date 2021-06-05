package assembly.x86.registers;

public final class DRegister extends x86Register {
    protected DRegister() {}

    @Override
    protected String oneByteName() {
        return "%dl";
    }

    @Override
    protected String fourBytesName() {
        return "%edx";
    }

    @Override
    protected String eightBytesName() {
        return "%rdx";
    }
}
