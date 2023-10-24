import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapLock {
    private static final Set<Integer> synchronizedSet = new HashSet<>();
    private static final Map<Integer, String> mapLock = new HashMap<>();
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread addToSetThread = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                synchronized (synchronizedSet) {
                    synchronizedSet.add(i);
                }
            }
        });

        Thread addToMapThread = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                lock.lock();
                try {
                    mapLock.put(i, "Value" + i);
                } finally {
                    lock.unlock();
                }
            }
        });

        addToSetThread.start();
        addToMapThread.start();

        addToSetThread.join();
        addToMapThread.join();

        System.out.println("synchronizedSet: " + synchronizedSet.size());
        System.out.println("mapLock: " + mapLock.size());
    }
}
