package assembly.x86.registers;

import assembly.AssemblyRegister;

public abstract class x86Register extends AssemblyRegister {
    public static final x86Register A = new ARegister(), B = new BRegister(), C = new CRegister(), D = new DRegister();

    @Override
    public String name(int bytes) {
        return switch (bytes) {
            case 1 -> oneByteName();
            case 4 -> fourBytesName();
            case 8 -> eightBytesName();
            default -> throw new RuntimeException("Invalid size " + bytes + "B for x86Register. Valid options: 1B, 4B and 8B");
        };
    }
    
    protected abstract String oneByteName();
    
    protected abstract String fourBytesName();
    
    protected abstract String eightBytesName();
}
