package interfacePractice;

public class Main {
    public static void main(String[] args) {
        MyClass myClass=new MyClass();
        myClass.read();
        myClass.print();
        System.out.println("inside main");
        System.out.println(Interface1.calculate(10,12));


        MyClass2 myClass2=new MyClass2();
        Interface4.call();
    }

}
