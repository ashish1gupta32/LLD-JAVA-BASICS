package thread;

import java.time.Duration;
import java.time.Instant;

public class ThreadLocalAndVirtualThreadPractice {
    static public class Practice{
        ThreadLocal<Integer> cnt=new ThreadLocal<>();
        Practice(){
            cnt.set(0);
        }
        int increase(){
            cnt.set(cnt.get()+1);
            return cnt.get();
        }


    }
    public static void main(String[] args) throws InterruptedException{
        for(int i=0;i<3;i++) {
            threadProcessing();
            virtualThreadProcessing();
        }
    }

    private static void threadProcessing() throws InterruptedException {
        Instant inst=Instant.now();
        Practice practice1=new Practice();
        Thread th1=new Thread(()->{
            practice1.cnt.set(0);
            for(int i=0;i<100000000;i++)
              practice1.increase();
            System.out.println(practice1.cnt.get());
        });
        Thread th2=new Thread(()->{
            practice1.cnt.set(0);
            for(int i=0;i<1000000000;i++)
                practice1.increase();
            System.out.println(practice1.cnt.get());
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(practice1.cnt.get());
        System.out.println("Platform Thread-total time taken:"+ Duration.between(inst,Instant.now()).toMillis());
    }
    private static void virtualThreadProcessing() throws InterruptedException {
        Instant inst=Instant.now();
        Practice practice1=new Practice();
        Thread th1=Thread.ofVirtual().name("mythread1").start(()->{
            practice1.cnt.set(0);
            for(int i=0;i<100000000;i++)
                practice1.increase();
            System.out.println(practice1.cnt.get());
        });
        Thread th2=Thread.ofVirtual().name("mythread2").start(()->{
            practice1.cnt.set(0);
            for(int i=0;i<1000000000;i++)
                practice1.increase();
            System.out.println(practice1.cnt.get());
        });
        th1.join();
        th2.join();
        System.out.println(practice1.cnt.get());
        System.out.println("Virtual Thread-total time taken:"+ Duration.between(inst,Instant.now()).toMillis());
    }
}
