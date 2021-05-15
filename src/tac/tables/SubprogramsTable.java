package tac.tables;

import tac.references.TACSubprogram;
import tac.references.TACTag;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SubprogramsTable {
    private final Map<String, SubprogramInfo> subprogramsMap = new HashMap<>();

    public SubprogramInfo get(String identifier) {
        return subprogramsMap.get(identifier);
    }

    public SubprogramInfo get(TACSubprogram tacSubprogram) {
        for (SubprogramInfo subprogramInfo : subprogramsMap.values()) {
            if (subprogramInfo.getTacSubprogram().equals(tacSubprogram)) {
                return subprogramInfo;
            }
        }
        return null;
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
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Optional<SubprogramInfo> longestSubprogram = subprogramsMap.values().stream()
                .reduce((subprogram1, subprogram2)
                        -> subprogram1.getTacSubprogram().toString().length() > subprogram2.getTacSubprogram().toString().length()
                        ? subprogram1 : subprogram2);
        int longestSubprogramName = Math.max(longestSubprogram.map(info -> info.getTacSubprogram().toString().length()).orElse(0), 10);
        String format = "%12s%" + longestSubprogramName + "s%" + (longestSubprogramName + 3) + "s%8s%10s\n";

        printWriter.format(format, "Código", "Nombre", "Etiqueta", "TamVL", "Nº param");
        for (SubprogramInfo subprogramInfo : subprogramsMap.values()) {
            printWriter.format(format,
                    subprogramInfo.getTacSubprogram(),
                    subprogramInfo.getIdentifier(),
                    subprogramInfo.getTag(),
                    subprogramInfo.getLocalVariablesSize() + "B",
                    subprogramInfo.getNumParameters()
            );
        }
        return stringWriter.toString();
    }

    public static final class SubprogramInfo {
        private final String identifier;
        private final TACSubprogram tacSubprogram;
        private final TACTag tag;
        private int localVariablesSize;
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

        public void setLocalVariablesSize(int localVariablesSize) {
            this.localVariablesSize = localVariablesSize;
        }

        public int getNumParameters() {
            return numParameters;
        }
    }
}
