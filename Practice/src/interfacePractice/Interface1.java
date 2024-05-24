package interfacePractice;

import java.util.Random;

public interface Interface1 {

//    Java 8 features a)default
    default void print(){
        System.out.println("printing.... inside interface1");
        Random random=new Random();
        System.out.println("calculating some of two random number");
        System.out.println(calculate(random.nextInt(100),random.nextInt(100)));
        System.out.println(multiply(random.nextInt(100),random.nextInt(100)));
    }
    void read();

//    Java 8 features b)static
    static int calculate(int a,int b){
        System.out.print("a:"+a);
        System.out.print(" b:"+b+" ");
        return a+b;
    }
//    JAVA 9 Features a)private static  method
    private static int multiply(int a,int b){
        System.out.print("a:"+a);
        System.out.print(" b:"+b+" ");
        return a*b;
    }
//    JAVA 9 Features b)private method
    private int subtract(int a,int b){
        System.out.print("a:"+a);
        System.out.print(" b:"+b+" ");
        return a-b;
    }
}
