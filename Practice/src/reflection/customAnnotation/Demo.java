package reflection.customAnnotation;

@MyAnnotation(value = "my annotation")
public class Demo {
    public String method(String st){
        System.out.println(st);
        return st;
    }

    public int method2(int val){
        return val*2;
    }
}
