package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HackerThreadPractice {
    static int maxNum=10000;
    public static void main(String[] args) {
        Random random=new Random();
        Vault vault=new Vault(random.nextInt(maxNum));
        AscendingThread ascendingThread=new AscendingThread(vault);
        PoliceThread policeThread=new PoliceThread();
        ascendingThread.start();
        policeThread.start();
        List<Runnable> tasks=new ArrayList<>();
        List<Thread> lst=tasks.stream().map(Thread::new).toList();

    }
    public  static class Vault{
        int password;
        public Vault(int password){
            this.password=password;
        }
        public boolean isCorrectPassword(int password){
            try {
                Thread.sleep(5);
            }catch (Exception ex){
                System.out.println("some exception appeared");
            }
            return this.password==password;
        }
    }
    public static class HackerThread extends Thread{
        Vault vault;
        public HackerThread(Vault vault){
            this.vault=vault;
        }
        @Override
        public void start(){
            System.out.println("thread started:"+this.getName());
            super.start();
        }
    }
    public static class AscendingThread extends HackerThread{
        public AscendingThread(Vault vault){
            super(vault);
        }
        @Override
        public void run(){
            for(int i=0;i<maxNum;i++){
                if(vault.isCorrectPassword(i))
                {
                    System.out.println("password guessed by thread:"+getName());
                    System.exit(0);
                }
            }
        }
    }
    public static class PoliceThread extends Thread{
        @Override
        public void run(){
            for(int i=10;i>0;i--){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            System.out.println("police catches thief");
            System.exit(1);
        }
    }
}
