package optimizers.utils;

import java.util.ArrayList;
import java.util.List;

public final class BasicBloc {
    private final int id, startLineNumber;
    private int endLineNumber;
    private final String name;
    private final List<BasicBloc> successors = new ArrayList<>();

    public BasicBloc(int id, int startLineNumber) {
        this.id = id;
        this.startLineNumber = startLineNumber;
        this.name = null;
    }

    private BasicBloc(String name, int id, int startLineNumber, int endLineNumber) {
        this.name = name;
        this.id = id;
        this.startLineNumber = startLineNumber;
        this.endLineNumber = endLineNumber;
    }

    public int getId() {
        return id;
    }

    public int getStartLineNumber() {
        return startLineNumber;
    }

    public void setEndLineNumber(int endLineNumber) {
        this.endLineNumber = endLineNumber;
    }

    public int getEndLineNumber() {
        return endLineNumber;
    }

    public List<BasicBloc> getSuccessors() {
        return successors;
    }

    public void addSuccessor(BasicBloc successor) {
        successors.add(successor);
    }

    public boolean isStartOrEndBasicBloc() {
        return "E".equals(name) || "S".equals(name);
    }

    public String toDot() {
        StringBuilder buffer = new StringBuilder();
        successors.forEach(successor -> buffer.append(this).append(" -> ").append(successor).append(";\n"));
        return buffer.toString();
    }

    @Override
    public String toString() {
        return name != null ? name : String.valueOf(id);
    }

    public static BasicBloc generateStart() {
        return new BasicBloc("S", Integer.MIN_VALUE, 0, 0);
    }

    public static BasicBloc generateEnd() {
        return new BasicBloc("E", Integer.MAX_VALUE, 0, 0);
    }
}
