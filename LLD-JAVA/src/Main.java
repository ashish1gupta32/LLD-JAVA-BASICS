import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    volatile static AtomicInteger st = new AtomicInteger(12);

    public static void main(String[] args) {


        Map<Integer,Integer> mp=new ConcurrentHashMap<>();
        mp.put(12,12);
        mp.put(13,13);
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println(".....................");
        Iterator<Map.Entry<Integer, Integer>> itr=mp.entrySet().iterator();
        Map<Integer,Integer> mp2=new ConcurrentHashMap<>();
        mp2.put(12,13);
        mp2.put(13,14);
        mp.putAll(mp2);
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

//        AtomicInteger

        List<Integer> lst=new LinkedList<>();
        lst.add(111);
        lst.add(112);
//        check(lst);
        check2(lst,mp2);
//        List<?> lst2=lst;
//
//        lst2.add(11);
//        lst2.add(12);

        Map<String,List<? super Integer>>mp1=new HashMap<>();
        mp1.put("key",lst);
        mp1.get("key").add(11);

        Map<String,List<? extends Integer>>mp3=new HashMap<>();
        mp3.put("key",lst);
//        mp3.get("key").add(11); //error because of upper bound wildcard


        System.out.println("Main task completed");
    }



    static void check(List<?> lst){
       lst.forEach(System.out::println);
       for(int i=0;i<lst.size();i++){
//           Integer st=lst.get(i); //read or insert is not possible
           System.out.println(lst.get(i));
       }
    }

    static  <T,V> void check2( List<V> lst,Map<T,V> mp2){
        lst.forEach(System.out::println);
        for(int i=0;i<lst.size();i++){
           V st=lst.get(i);
            System.out.println(st);
        }
    }


}