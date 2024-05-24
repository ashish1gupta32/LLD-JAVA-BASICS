package synchronizePractice;

public class Demo {
    int counter=0;
    synchronized void increment(){
        System.out.println(Thread.currentThread().getName()+" : "+counter);
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
