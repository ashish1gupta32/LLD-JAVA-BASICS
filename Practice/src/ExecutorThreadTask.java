import java.util.List;
import java.util.concurrent.*;

public class ExecutorThreadTask {
    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor serv = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> ft = serv.submit(() -> {
                    try {
                        Thread.sleep(6700);
                    }
                    catch (Exception e){}
                    for (int i = 0; i <= 10000; i++) {
                        System.out.println("Completed: "+i);
                    }
                }
        );
        List<Runnable> val=serv.shutdownNow();
        System.out.println("size="+val.size());
        System.out.println("is shutdown done: "+serv.awaitTermination(7,TimeUnit.SECONDS));

        try {
            ft.get(8, TimeUnit.MILLISECONDS);
        }catch (Exception e){}
        ScheduledExecutorService serv2= Executors.newScheduledThreadPool(2);

        Future<?> ft2=serv2.scheduleAtFixedRate(()->{
            System.out.println("thread task completed");
        },3,2,TimeUnit.SECONDS);
        ft2.get();


        System.out.println("Main Task completed");
    }
}
