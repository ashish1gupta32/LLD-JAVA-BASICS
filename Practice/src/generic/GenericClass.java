package generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericClass<T,V extends Number> implements Comparable<GenericClass>{
    Map<T,V> mp=new HashMap<>();
    public V putValue(T key, V value){
        mp.put(key,value);
        return value;
    }
    public void showValue(List<? extends Number> lst){
        for(Number num:lst){
            System.out.println(num);
        }
        lst.forEach(System.out::println);
    }





    @Override
    public int compareTo(GenericClass genericClass) {
        return this.mp.size()>genericClass.mp.size()?1:-1;
    }
}
