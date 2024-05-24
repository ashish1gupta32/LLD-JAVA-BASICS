package synchronizePractice;

public class Main {
    public static void main(String[] args) throws Exception{
        Demo inst1=new Demo();
        Demo inst2=new Demo();
        Thread th1=new Thread(()->{
            for(int i=0;i<10000;i++)inst1.increment();
        });
        Thread th2=new Thread(()->{
            for(int i=0;i<10000;i++)inst2.increment();
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(inst1.getCounter());
        System.out.println(inst2.getCounter());
    }
}
