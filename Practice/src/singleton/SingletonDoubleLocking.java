package singleton;

public class SingletonDoubleLocking {
    private  static volatile SingletonDoubleLocking instance;
    private SingletonDoubleLocking(){
    }
    public  static  SingletonDoubleLocking getInstance() {
        if(instance==null){
            synchronized (SingletonDoubleLocking.class) {
                if(instance==null) {
                    instance = new SingletonDoubleLocking();
                }
            }
        }
        return instance;
    }
}
