import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Tasks {
    public static void main(String[] args) throws InterruptedException {
        int numberOfT = 3;
        
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfT);
        
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        
        for (int i = 0; i < 6; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("Задача выполняется в " + Thread.currentThread().getName());
            }, executorService).thenAccept(result -> {
                System.out.println("Задача выполнена.");
            });
            
            futures.add(future);
        }
        
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();
        
        executorService.shutdown();
    }
}

