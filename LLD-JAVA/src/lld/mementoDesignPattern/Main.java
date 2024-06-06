package lld.mementoDesignPattern;

public class Main {
    public static void main(String[] args) {
        CareTaker careTaker=new CareTaker();
        Originator originator=new Originator();
        originator.setName("abc");
        originator.setValue("12");
        Memento snapshot=originator.createMemento();
        careTaker.saveMemento(snapshot);

        originator.setName("abcd");
        originator.setValue("123");
        snapshot=originator.createMemento();
        careTaker.saveMemento(snapshot);

        originator.setName("abcde");
        originator.setValue("1234");
        snapshot=originator.createMemento();
        careTaker.saveMemento(snapshot);

        originator.setName("abcdfef");
        originator.setValue("12345");
        snapshot=careTaker.undo();
        originator.restorState(snapshot);

        System.out.println(STR."\{originator.name}  : \{originator.value}");

        snapshot=careTaker.undo();
        originator.restorState(snapshot);

        System.out.println(originator.name+ " : "+originator.value);

    }
}
