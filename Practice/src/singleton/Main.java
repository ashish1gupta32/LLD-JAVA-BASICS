package singleton;

public class Main {
    public static void main(String[] args) {
        //Eager Initialization
        SingletonEagerIntialization instance1=SingletonEagerIntialization.getInstance();
        //Lazy Initialization
        SingletonSynchronized  instance2=SingletonSynchronized.getInstance();
        SingletonDoubleLocking instance3=SingletonDoubleLocking.getInstance();
        SingletonBillPaugh     instance4=SingletonBillPaugh.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);
        System.out.println(instance4);
    }
}
