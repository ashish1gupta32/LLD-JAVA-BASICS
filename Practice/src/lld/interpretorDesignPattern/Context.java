package lld.interpretorDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String,Integer> context=new HashMap<>();

    public void addContext(String var,int val){
        context.put(var,val);
    }

    public int getContext(String var){
        return context.get(var);
    }
}
