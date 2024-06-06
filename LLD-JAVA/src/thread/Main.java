package thread;

public class Main {
    public static void main(String[] args) throws Exception{
        Thread th1 = new Thread(() -> {
            throw new RuntimeException("Run time exception");
//            Thread.sleep(100);
//            System.out.println("thread1");
        });
        Runnable runnable=()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("sleep interuppted");
            }
            if (Thread.interrupted()){
                System.out.println("thread interuppted");
            }
        };
        Runnable runnable2=()->{
            for (int i=0;i<=1000000;i++){
                if (Thread.interrupted()){
                    System.out.println("thread interuppted");
                }
            }

        };
        Thread th2=new Thread(runnable);
        Thread th3=new Thread(runnable2);
        th1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Some exception appeared for thread:" + t.getName());
            System.out.println(e.getMessage());
        });
        th1.start();
        th1.join();
        th2.start();
        th2.interrupt();
        th3.start();
        th3.interrupt();
    }

}
