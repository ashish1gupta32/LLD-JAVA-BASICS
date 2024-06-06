package singleton;

public class SingletonSynchronized {
    private  static SingletonSynchronized instance;
    private SingletonSynchronized(){
        synchronized (SingletonSynchronized.class) {
//            // Prevent multiple instances from being created using reflection
//            if (instance != null) {
//                throw new IllegalStateException("Singleton instance already exists");
//            }
//            // Initialize the singleton instance
//            instance = this;
        }
    }
    public  static synchronized SingletonSynchronized getInstance() {
        if(instance==null){
            instance=new SingletonSynchronized();
        }
        return instance;
    }
}
