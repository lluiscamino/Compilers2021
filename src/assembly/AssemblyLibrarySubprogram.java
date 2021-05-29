package assembly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AssemblyLibrarySubprogram {
    private final List<AssemblyLibrarySubprogram> dependencies;
    private boolean used = false;

    public AssemblyLibrarySubprogram() {
        this.dependencies = new ArrayList<>();
    }

    public AssemblyLibrarySubprogram(List<AssemblyLibrarySubprogram> dependencies) {
        this.dependencies = dependencies;
    }

    public abstract String alias();

    public abstract String assemblyCode();

    public boolean isUsed() {
        return used;
    }

    public void setUsed() {
        this.used = true;
        for (AssemblyLibrarySubprogram dependency : dependencies) {
            dependency.setUsed();
        }
    }

    public void addToMap(Map<String, AssemblyLibrarySubprogram> map) {
        map.put(alias(), this);
    }
}
