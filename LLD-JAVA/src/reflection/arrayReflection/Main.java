package reflection.arrayReflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    static class MyClass<T>{
        static <T> T getArray(Class<?> type,Object ...args){
            Object obj= Array.newInstance(type,2);
            Array.set(obj,0,args[0]);
            Array.set(obj,1,args[1]);
            return (T)obj;
        }
    }
    public static <T> T getElement(List<?> list, int index)
    { return (T) list.get(index); }
    public static <T> T getElement(Class<T> type,List<?> list, int index)
    { return (T) list.get(index); }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyClass obj= MyClass.class.getDeclaredConstructor().newInstance();
        Integer [] val=obj.getArray(Integer.class,12,13);
        System.out.println(val[0]);
        System.out.println(val[1]);

        String [] val2=obj.getArray(String.class,"val1","val2");
        System.out.println(val2[0]);
        System.out.println(val2[1]);
        int lstValue=getElement(List.of(1, 2, 3), 1);
        System.out.println(lstValue);

        int lstValue2=getElement(Integer.class,List.of(1, 2, 3), 1);
        System.out.println(lstValue2);
    }




}
