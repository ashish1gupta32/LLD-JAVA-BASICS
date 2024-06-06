package reflection.configReader.model;

public class Student {
    private String name;
    private int age;
    private int rollNo;
    private int rank;
    public Student(){};

//    @Override
//    public String toString() {
//        return super.toString();
//    }

    @Override
    public String toString() {
        return "name:"+this.name+"\n"+"age:"+age+"\nrollNo:"+this.rollNo+"\nrank:"+rank;
    }
}
