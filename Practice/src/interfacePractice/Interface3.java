package interfacePractice;

public interface Interface3 extends Interface1,Interface2{
    @Override
    default void print() {
        Interface1.super.print();
        System.out.println("printing.... inside interface3");
    }
}
