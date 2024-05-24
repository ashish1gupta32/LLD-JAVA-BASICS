package reflection;

import reflection.customAnnotation.Demo;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Main {
    static Function<Integer,Integer> ft=(val)->val*2;
    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        Method method = demo.getClass().getMethod("method", String.class);
        String str = (String) method.invoke(demo, "testing");
        System.out.println(str);

        Method method2 = demo.getClass().getMethod("method2", int.class);
        int val = (int) method2.invoke(demo, 12);
        System.out.println(val);

        System.out.println("className: " + demo.getClass().getName());
        Class cl = Demo.class;
        System.out.println(cl.getMethod("method2", int.class).invoke(demo,12));
        for(var val1:cl.getAnnotations())System.out.print(val1);
        for(var val1:cl.getMethods())System.out.print(val1);
        System.out.println();
        Thread.sleep(100);
        System.out.println("main completed");
        System.out.println(ft.apply(15));
        int[] arr ={1,2,3,4};
        System.out.println(arr.length);
        System.out.println(Array.getLength(arr));
        System.out.println(arr.getClass().getComponentType());
        Array.get(arr,0);

//        error
//                Enum

    }
}
