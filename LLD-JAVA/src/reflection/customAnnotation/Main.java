package reflection.customAnnotation;

public class Main {
    public static void main(String[] args) {
        Demo demo=new Demo();
        Class<? extends Demo> cl=demo.getClass();
        MyAnnotation myAnnotation=(MyAnnotation)cl.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
    }
}
