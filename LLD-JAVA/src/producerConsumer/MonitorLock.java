package producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorLock {

    public static void main(String []args){
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Resource resource1=new Resource();
        Thread th1=new Thread(()->{
            resource1.produce(lock,condition);
        });

        Resource resource2=new Resource();
        Thread th2=new Thread(()->{
            resource2.produce(lock,condition);
        });
        th1.start();th2.start();

    }
}
