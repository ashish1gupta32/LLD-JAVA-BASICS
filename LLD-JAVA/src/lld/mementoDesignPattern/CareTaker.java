package lld.mementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    List<Memento> ls=new ArrayList<>();
    void saveMemento(Memento memento){
        ls.add(memento);
    }
    Memento undo(){
        if(!ls.isEmpty()){
            int lst=ls.size()-1;
            Memento memento=ls.get(lst);
            ls.remove(lst);
            return memento;
        }
        return null;
    }
}
