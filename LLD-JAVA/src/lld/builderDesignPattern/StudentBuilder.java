package lld.builderDesignPattern;

public class StudentBuilder {
    String name;
    int rollNo;
    int age;

    StudentBuilder name(String name){
        this.name=name;
        return this;
    }

    StudentBuilder rollNo(int rollNo){
        this.rollNo=rollNo;
        return this;
    }
    StudentBuilder age(int age){
        this.age=age;
        return this;
    }

    Student build(){
        return new Student(this);
    }

}
