package lld.builderDesignPattern;

public class Student {
    String name;
    int rollNo;
    int age;
    Student(StudentBuilder sb){
        this.name = sb.name;
        this.rollNo = sb.rollNo;
        this.age = sb.age;
    }
    @Override
    public String toString(){
        return STR."name : \{name},\nage : \{age},\nrollNo : \{rollNo}";
    }
}
