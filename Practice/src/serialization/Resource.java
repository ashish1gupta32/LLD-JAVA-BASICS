package serialization;

import java.beans.Transient;
import java.io.Serializable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Resource implements Serializable {
    int capacity=10;
    String value="resource";

    transient int cnt;
    void produce(ReentrantLock lock,Condition condition){
        lock.lock();
        System.out.println("lock acquired by "+Thread.currentThread().getName());
        condition.signal();
        try {
            condition.await();
            condition.signal();
            System.out.println("waiting completed");
            Thread.sleep(4000);
        }catch(Exception e){}
        System.out.println("thread job completed,releasing lock");
        lock.unlock();
    }

    @Override
    public String toString() {
        return " "+value+":"+capacity+" "+" "+cnt;
    }
}
