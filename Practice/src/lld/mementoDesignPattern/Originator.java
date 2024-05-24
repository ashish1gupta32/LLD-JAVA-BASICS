package lld.mementoDesignPattern;

public class Originator {
    String name;
    String value;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Memento createMemento(){
        return new Memento(this.name,this.value);
    }
    void restorState(Memento memento){
        this.name=memento.getName();
        this.value=memento.getValue();
    }


}
