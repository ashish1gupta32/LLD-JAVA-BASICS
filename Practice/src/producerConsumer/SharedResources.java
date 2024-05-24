package producerConsumer;

public class SharedResources {
    boolean available=false;
    synchronized public void  produce(){
        available=true;
        System.out.println("Producer task completed");
        System.out.println("notifying consumer thread");
        notify();
    }
    synchronized public void consume(){
        while(!available){
            try {
                System.out.println("waiting since data is not available");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available=false;
        System.out.println("Consumer Task completed");
    }
}
