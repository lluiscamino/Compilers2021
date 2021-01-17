package dot;

import java.util.LinkedList;
import java.util.Queue;

public final class DotIdGenerator {
    
    private static final Queue<Integer> queue = new LinkedList<>();
    private static int idAutoIncrement = 0;
    
    static {
        create();
    }
    
    private DotIdGenerator() {}
    
    public static void clear() {
        queue.clear();
        idAutoIncrement = 0;
        create();
    }

    public static int get() {
        return queue.poll();
    }
    
    public static int create() {
        queue.add(idAutoIncrement);
        return idAutoIncrement++;
    }
    
}
