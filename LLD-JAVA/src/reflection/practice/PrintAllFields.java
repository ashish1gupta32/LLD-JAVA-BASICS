package reflection.practice;

import java.lang.reflect.Field;

public class PrintAllFields {
    public static void main(String[] args) throws Exception {
        for(Field field:MyClass.class.getDeclaredFields()){
            System.out.println(String.format("Field name: %s type:%s",
                    field.getName(),
                    field.getType().getSimpleName()
            ));
        }
        Field field=MyClass.class.getDeclaredField("b");
        Object obj=new MyClass();
        field.setAccessible(true);
        System.out.println(field.get(obj));
    }
}
