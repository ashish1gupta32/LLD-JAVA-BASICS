package singleton;

import java.io.Serializable;

public class SingletonEagerIntialization implements Serializable {
    private  static SingletonEagerIntialization instance=new SingletonEagerIntialization();
    private SingletonEagerIntialization(){
        //protect from reflection
//        if (instance != null) {
//            throw new IllegalStateException("Singleton instance already exists");
//        }
    }
    public static SingletonEagerIntialization getInstance() {
        return instance;
    }

    protected Object readResolve(){
        return instance;
    }
}
