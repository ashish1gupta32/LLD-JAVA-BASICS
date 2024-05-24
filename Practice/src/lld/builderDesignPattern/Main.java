package lld.builderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Student student = new StudentBuilder().name("ASH").age(12).rollNo(101).build();
        System.out.println(student.toString());
    }
}
