package atomicReferenceStack;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<Integer> val = new AtomicReference<>(0);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int mx=1000;
        Thread th1 = new Thread(() -> {
            for (int i = 0; i < mx; i++) {
                //val.set(val.get()+1);  //this method will have thread issue
                // 1st way
                int value = 0;
                do {
                    LockSupport.parkNanos(1);
                    value = val.get();
                } while (!val.compareAndSet(value, value + 1));
            }
        });
        Thread th2 = new Thread(() -> {
            for (int i = 0; i < mx; i++) {
                //val.set(val.get()-1);    //this method will have thread issue
                // 1st way
                int value = 0;
                do {
                    LockSupport.parkNanos(1);
                    value = val.get();
                } while (!val.compareAndSet(value, value - 1));
            }
        });
        Thread th3 = new Thread(() -> {
            for (int i = 0; i < mx; i++) {
                //2nd way
                val.updateAndGet(v -> v + 1); //this is  thread safe;
            }
        });
        Thread th4 = new Thread(() -> {
            for (int i = 0; i < mx; i++) {
                //2nd way
                val.updateAndGet(v -> v - 1); //this is  thread safe;
            }
        });
        Thread th5 = new Thread(atomicInteger::incrementAndGet);
        Thread th6 = new Thread(atomicInteger::decrementAndGet);
        long start = System.currentTimeMillis();
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(val.get());
        System.out.println(STR."total time taken in 1st way= \{(System.currentTimeMillis() - start)}ms");

        start = System.currentTimeMillis();
        th3.start();
        th4.start();
        th3.join();
        th4.join();
        System.out.println(val.get());
        System.out.println(STR."total time taken in 2nd way = \{(System.currentTimeMillis() - start)}ms");

        start = System.currentTimeMillis();
        th5.start();
        th6.start();
        th5.join();
        th6.join();
        System.out.println(val.get());
        System.out.println(STR."total time taken in 3rd way = \{(System.currentTimeMillis() - start)}ms");

        Deque<Integer> dq=new ArrayDeque<>();
        dq.add(123);
        List<Integer> lst=new LinkedList<>();
        lst.add(23);
        Map<Integer,Integer> mp=new TreeMap<>(Comparator.comparingInt(a -> a));
        mp.put(12,12);
        // import deep copy and shallow copy
        /*Map<Integer,Integer> mp=new HashMap<>();
        int[]tmp1=new int[1];
        tmp1[0]=0;
        for(int x:tmp1){
            System.out.println(x);
        }
        int[]tmp2=tmp1.clone();
        tmp2[0]=1010;
        for(int x:tmp1){
            System.out.println(x);
        }*/
    }
}
