package immutablePractice;

import java.util.*;

public final class MyImmutableClass {
    private String st;
    private List<String> lst;
    MyImmutableClass(String st,List<String>lst){
        this.st=st;
        this.lst=lst;
    }

    public List<String> getLst() {
        return Collections.unmodifiableList(lst);
    }

    public String getSt() {
        return st;
    }
}
