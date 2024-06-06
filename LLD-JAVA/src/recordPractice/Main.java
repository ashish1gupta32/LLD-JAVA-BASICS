package recordPractice;

public class Main {
    public static void main(String[] args) {
        MyRecord myRecord=new MyRecord("abc",12);
        System.out.println(myRecord.name()+" : "+myRecord.age());
    }
}
