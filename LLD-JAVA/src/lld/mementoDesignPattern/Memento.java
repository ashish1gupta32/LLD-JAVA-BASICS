package lld.mementoDesignPattern;

public class Memento {
    String name;
    String value;
    Memento(String name,String value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
