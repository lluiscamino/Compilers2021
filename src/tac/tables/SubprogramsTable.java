package tac.tables;

import tac.references.TACSubprogram;
import tac.references.TACTag;

import java.util.ArrayList;

public final class SubprogramsTable {
    public static final class SubprogramInfo {
        private TACTag tag;
        private int localVariablesSize;
        private int numParameters;

        public SubprogramInfo(TACTag tag, int numParameters) {
            this.tag = tag;
            this.numParameters = numParameters;
        }

        public TACTag getTag() {
            return tag;
        }

        public void setTag(TACTag tag) {
            this.tag = tag;
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

        public void setNumParameters(int numParameters) {
            this.numParameters = numParameters;
        }
    }

    private final ArrayList<SubprogramInfo> subprogramsList = new ArrayList<>();

    public SubprogramInfo get(TACSubprogram tacSubprogram) {
        return subprogramsList.get(tacSubprogram.getId());
    }

    public void add(TACSubprogram tacSubprogram, TACTag tacTag, int numParameters) {
        subprogramsList.add(tacSubprogram.getId(), new SubprogramInfo(tacTag, numParameters));
    }

    public int size() {
        return subprogramsList.size();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Código\tTam. var. local\tNúm. params.\n");
        for (SubprogramInfo subprogramInfo : subprogramsList) {
            buffer.append(subprogramInfo.getTag()).append("\t\t")
                    .append(subprogramInfo.getLocalVariablesSize()).append("\t\t\t\t")
                    .append(subprogramInfo.getNumParameters()).append("\n");
        }
        return buffer.toString();
    }
}
