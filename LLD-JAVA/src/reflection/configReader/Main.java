package reflection.configReader;

import reflection.configReader.model.Student;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static  String path="/Users/ashishgupta/Documents/sublimeText/Practice/src/reflection/configReader/student.config";
    public static void main(String[] args) throws Exception {
        Student student=new Student();
        System.out.println("reading data from config file");
//        try(FileInputStream file=new FileInputStream("/Users/ashishgupta/Documents/sublimeText/Practice/src/reflection.configReader/student.config");
//            InputStreamReader inputStreamReader= new InputStreamReader(file) ;
//            BufferedReader reader=new BufferedReader(inputStreamReader)){


            try (BufferedReader reader= Files.newBufferedReader(Paths.get(path))){
            String read;
            while((read=reader.readLine())!=null){
                String []val=read.split(":");
                String key=val[0];
                String value=val[1];
                try {
                    Field field = student.getClass().getDeclaredField(key);
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    field.set(student, parseValue(type, value));
                }
                catch (Exception ex){
                    System.out.println(String.format("Ignoring this field=%s as field not exist",key));
                }
            }
                try(FileWriter writer=new FileWriter(path,true)){
                    writer.append("\nschool:abc");
                }
        }
        catch (Exception ex){
            System.out.println("some exception appeared");
            throw ex;
        }
        System.out.println(student.toString());



    }

    private static Object parseValue(Class<?> type, String value) {
        if(type==int.class){
            return Integer.parseInt(value);
        }
        else if(type==double.class){
            return Double.parseDouble(value);
        }
        else if(type.equals(float.class)){
            return Float.parseFloat(value);
        }

        return value;
    }
}
