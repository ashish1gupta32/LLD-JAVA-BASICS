package reflection.practice;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//3 ways to get class
public class Main {
    static void findAllMethods(Class<? extends List<Integer>> clazz){
        System.out.println(clazz.getName());
    }
    class Car{
        int tmp[];
        Car(){};
        public void method1(){
            System.out.println("method1");
        }
    }
    public static void main(String[] args) throws Exception {
        Object obj=new MyClass();
        Class myClass1 = obj.getClass();
        Class myClass2 = MyClass.class;
        Class myClass3 = Class.forName("reflection.practice.MyClass");
        System.out.println(myClass1.getName());
        System.out.println(myClass2.getName());
        System.out.println(myClass3.getName());
        List<Integer> lst=new ArrayList<>();
        Main main=new Main();
        Car car=main.new Car();
        Field field=car.getClass().getDeclaredField("tmp");
        System.out.println(field.getName()+":"+field.getType().getComponentType());
        if(field.getType()==String.class)System.out.println("yes");

        Class<?> clazz=Class.forName("reflection.practice.Main$Car");
        Constructor<?> constructor=clazz.getDeclaredConstructor(main.getClass());
        Object class2=constructor.newInstance(main);
        Class<?> clazz2=  Class.forName("reflection.practice.MyClass");
        Constructor<?> constructor1=clazz2.getDeclaredConstructor();
        MyClass myClass4=(MyClass) constructor1.newInstance();

//        System.out.println(car2.getClass().getMethod("method1").invoke(car2));
        Method method=car.getClass().getMethod("method1");
        System.out.println(car.getClass().isPrimitive());
//        car.getClass().getP

//        findAllMethods(lst.getClass());

    }
}
