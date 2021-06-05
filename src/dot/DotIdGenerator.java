package dot;

import java.util.LinkedList;
import java.util.Queue;

public final class DotIdGenerator {
    
    private final Queue<Integer> queue = new LinkedList<>();
    private int idAutoIncrement = 0;
    
    public DotIdGenerator() {
        create();
    }

    public int get() {
        if (queue.isEmpty()) {
            throw new RuntimeException("DotIdGenerator: Cannot call get() before create()");
        }
        return queue.poll();
    }
    
    public int create() {
        queue.add(idAutoIncrement);
        return idAutoIncrement++;
    }
    
}
