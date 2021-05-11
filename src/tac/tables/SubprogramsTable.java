package tac.tables;

import tac.references.TACSubprogram;
import tac.references.TACTag;

import java.util.HashMap;
import java.util.Map;

public final class SubprogramsTable {
    private final Map<String, SubprogramInfo> subprogramsMap = new HashMap<>();

    public SubprogramInfo get(String identifier) {
        return subprogramsMap.get(identifier);
    }

    public void add(String identifier, TACSubprogram tacSubprogram, TACTag tacTag, int numParameters) {
        SubprogramInfo subprogramInfo = new SubprogramInfo(identifier, tacSubprogram, tacTag, numParameters);
        subprogramsMap.put(identifier, subprogramInfo);
    }

    public int size() {
        return subprogramsMap.size();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Código\tNombre\tEtiqueta\tTam. var. local\tNúm. params.\n");
        for (SubprogramInfo subprogramInfo : subprogramsMap.values()) {
            buffer.append(subprogramInfo.getTacSubprogram()).append("\t\t")
                    .append(subprogramInfo.getIdentifier()).append("\t\t")
                    .append(subprogramInfo.getTag()).append("\t\t")
                    .append(subprogramInfo.getLocalVariablesSize()).append("\t\t\t\t")
                    .append(subprogramInfo.getNumParameters()).append("\n");
        }
        return buffer.toString();
    }

    public static final class SubprogramInfo {
        private final String identifier;
        private final TACSubprogram tacSubprogram;
        private final TACTag tag;
        private final int localVariablesSize;
        private final int numParameters;

        public SubprogramInfo(String identifier, TACSubprogram tacSubprogram, TACTag tag, int numParameters) {
            this.identifier = identifier;
            this.tacSubprogram = tacSubprogram;
            this.tag = tag;
            this.localVariablesSize = 0;
            this.numParameters = numParameters;
        }

        public String getIdentifier() {
            return identifier;
        }

        public TACSubprogram getTacSubprogram() {
            return tacSubprogram;
        }

        public TACTag getTag() {
            return tag;
        }

        public int getLocalVariablesSize() {
            return localVariablesSize;
        }

        public int getNumParameters() {
            return numParameters;
        }
    }
}
