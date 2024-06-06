package generic;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static class MyClass<T>{
        static <T> T getArray(Class<?> type,Object ...args){
            Object obj= Array.newInstance(type,2);
            Array.set(obj,0,args[0]);
            Array.set(obj,1,args[1]);
            return (T)obj;
        }
    }
    public static void main(String[] args) {
        //Generic Class
        GenericClass<String,Integer> genericObject=new GenericClass<>();
        genericObject.putValue("key1",12);
        genericObject.putValue("key2",122);
        //Wild Card
        List<Double> lst2=new ArrayList<>();
        lst2.add(1.2);
        lst2.add(22d);
        genericObject.showValue(lst2);

        //Sorting using comparator vs comparable
        GenericClass<String,Integer> genericObject2=new GenericClass<>();
        genericObject2.putValue("key1",12);

        List<GenericClass<String,Integer>> lst=new ArrayList<>();
        lst.add(genericObject);
        lst.add(genericObject2);

        Collections.sort(lst);
        System.out.println("lst0 size:"+lst.get(0).mp.size());
        Comparator<GenericClass<String,Integer>> cmp=(obj1,obj2)-> obj1.mp.size()<obj2.mp.size()?1:-1;
        lst.sort(cmp);
        System.out.println("lst0 size:"+lst.get(0).mp.size());


        try {

            MyClass<Integer[]> obj = MyClass.class.getDeclaredConstructor().newInstance();
            Integer[] val = obj.getArray(Integer.class, 12, 13);
            System.out.println(val[0]);
            System.out.println(val[1]);

            String[] val2 = obj.getArray(String.class, "val1", "val2");
            System.out.println(val2[0]);
            System.out.println(val2[1]);

        }
        catch (Exception ex){
            System.out.println("some exception appeared");
        }
    }
}
