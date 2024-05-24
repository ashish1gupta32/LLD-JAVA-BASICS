package lld.OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer,Integer> categoryMap=new HashMap<>();
    void addItem(int categoryId){
        int cnt=0;
        if(categoryMap.containsKey(categoryId))
        {
            cnt=categoryMap.get(categoryId);
        }
        cnt++;
        categoryMap.put(categoryId,cnt);
    }
    void removeItem(int categoryId){
        if(categoryMap.get(categoryId)==1)
            categoryMap.remove(categoryId);
        else categoryMap.put(categoryId,categoryMap.get(categoryId)-1);
    }
    void viewCart(){
        for(Map.Entry<?,?> entry:categoryMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println("................");
    }
}
