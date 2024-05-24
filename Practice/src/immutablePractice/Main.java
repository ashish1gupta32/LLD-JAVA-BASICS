package immutablePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String st="Demo";
        List<String> ls=new ArrayList<>();
        ls.add("abc");
        MyImmutableClass objL=new MyImmutableClass(st,ls);
        System.out.println(objL.getSt());
        objL.getLst().add("bcd");
        for(var val:objL.getLst()){
            System.out.println(val);
        }

    }
}
