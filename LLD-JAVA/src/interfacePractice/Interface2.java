package interfacePractice;

public interface Interface2 {
    default void print(){
        System.out.println("printing.... inside interface2");
    }
    void read();
}
