package singleton;

import java.io.*;
import java.lang.reflect.Constructor;

public class BreakSingletonPattern {
    public static void main(String[] args) throws Exception{
        //1 bt our object can also save from this attack read comment in class
        Constructor<SingletonEagerIntialization> construc =SingletonEagerIntialization.class.getDeclaredConstructor();
        construc.setAccessible(true);
        Object instance1=construc.newInstance();
        Object instance2=construc.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        //2 bt it should implement serialization... it again can save by implementing readResolve
        Object instance3=SingletonEagerIntialization.getInstance();
        byte[] serializeObj= serialize(instance3);
        Object instance4=deserialize(serializeObj);
        System.out.println(instance3);
        System.out.println(instance4);

        //break lazy initialization ... it also can saved check constructor comment
        Constructor<SingletonSynchronized> construc1 =SingletonSynchronized.class.getDeclaredConstructor();
        construc1.setAccessible(true);
        Object instance5=construc1.newInstance();
        Object instance6=construc1.newInstance();
        Object instance7=SingletonSynchronized.getInstance();
        System.out.println(instance5);
        System.out.println(instance6);
        System.out.println(instance7);

    }

    private static Object deserialize(byte[] serializeObj) throws Exception{
        try(ByteArrayInputStream bs=new ByteArrayInputStream(serializeObj);
           ObjectInputStream ois=new ObjectInputStream(bs)){
            return ois.readObject();
        }
        catch (Exception ex){
            return ex;
        }

    }

    private static byte[] serialize(Object instance3) throws Exception{
        try(ByteArrayOutputStream bs=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bs)
           ){
            oos.writeObject(instance3);
            return bs.toByteArray();
        }
        catch (Exception ex){
            throw ex;
        }
    }
}
