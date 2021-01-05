package dot;

import java.util.LinkedList;
import java.util.Queue;

final class DotIdGenerator {
    
    private static final Queue<Integer> queue = new LinkedList<>();
    private static int idAutoincrement = 0;
    
    static {
        create();
    }
    
    private DotIdGenerator() {}

    public static int get() {
        return queue.poll();
    }
    
    public static int create() {
        queue.add(idAutoincrement);
        return idAutoincrement++;
    }
    
}
