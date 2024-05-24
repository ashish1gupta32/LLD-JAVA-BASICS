package Rough;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String[]> lst=new ArrayList<>();
        lst.add(new String[]{"abc", "abc"});
        lst.add(new String[]{"abc", "bcd"});
        lst.add(new String[]{"abc", "bcnnnd"});
        lst.add(new String[]{"abc", "Documented"});

        lst.add(new String[]{"abcd", "Undocumented"});
//        lst=lst.stream().
//                collect(Collectors.toMap((obj)->obj[0], Function.identity(),(obj1, obj2)->obj2[1].equalsIgnoreCase("Documented")?obj2:obj1))
//                .values().stream().collect(Collectors.toList());
//        for(var val:lst)System.out.println(val[0]+" : "+val[1]);
        Map<String,List<String[]>> mp=lst.stream().collect(Collectors.groupingBy(obj->obj[1],Collectors.toList()));

//        for( var val:lst.stream().collect(Collectors.groupingBy(obj -> obj[0])).){
//            System.out.println(val.);
//        }
    }
}
