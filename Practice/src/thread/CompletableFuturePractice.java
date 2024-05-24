package thread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFuturePractice {
    public static void main(String[] args) throws Exception {
        Instant start = Instant.now();
        Supplier<String> supplier1 = () -> getString("thread1");
        Supplier<String> supplier2 = () -> getString("thread2");
        Callable<String> callable1 = () -> getString("thread1");
        Callable<String> callable2 = () -> getString("thread2");

        CompletableFuture<String> ft1 = CompletableFuture.supplyAsync(supplier1);
        CompletableFuture<String> ft2 = CompletableFuture.supplyAsync(supplier2);
        ft1.get();
        ft2.get();
        System.out.println("total time taken1:" + Duration.between(start, Instant.now()).toMillis());
        Instant start2 = Instant.now();
        ExecutorService serv = Executors.newFixedThreadPool(2);
        Future<String> fut1 = serv.submit(callable1);
        Future<String> fut2 = serv.submit(callable2);
        fut1.get();
        fut2.get();
        System.out.println("total time taken2:" + Duration.between(start2, Instant.now()).toMillis());
        serv.shutdown();
        serv.close();
    }

    private static String getString(String thread){
        try {
            for (int i = 0; i < 100000; i++) {
                if (i % 17171 == 0) {
                    System.out.println(thread);
                    Thread.sleep(100);
                }
            }
            return "passed";
        }catch (Exception ex){
            return "failed";
        }
    }
}
