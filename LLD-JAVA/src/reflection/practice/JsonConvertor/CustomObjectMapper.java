package reflection.practice.JsonConvertor;

import reflection.practice.Address;
import reflection.practice.MyClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CustomObjectMapper {
    public static String objectToJson(Object instance, int indentSize) throws Exception {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append(indent(indentSize));
        sb.append("{");
        sb.append("\n");
        for (int i=0;i<fields.length;i++) {
            Field field=fields[i];
            field.setAccessible(true);
            if (!field.isSynthetic()) {
                sb.append(indent(indentSize+1));
                sb.append(formatField(field));
                sb.append(":");
                if(field.getType().isPrimitive() || field.getType().equals(String.class)) {
                    sb.append(formattedValue(field, instance));
                }
                else sb.append(objectToJson(field.get(instance),indentSize+1));

                if(i!=fields.length-1)
                    sb.append(",");
                sb.append("\n");
            }
        }
        sb.append(indent(indentSize));
//        if (sb.length() > 1) sb.delete(sb.length() - 1, sb.length());
        sb.append("}");
        return sb.toString();
    }

    private static String formattedValue(Field field,Object instance) throws Exception  {
        if(field.getType().isPrimitive()){
            if(field.getType().equals(double.class) || field.getType().equals(float.class)){
                return String.format(".02f",field.get(instance));
            }
        }
        return field.get(instance).toString();
    }

    private static String indent(int indentSize) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indentSize; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    private static String formatField(Field field) {
        return String.format("\"%s\"", field.getName());
    }


    public static void main(String[] args) throws Exception {
        Constructor<Address> constructor =Address.class.getDeclaredConstructor(String.class,String.class);
        constructor.setAccessible(true);
        Address address=constructor.newInstance("cty","ctr");
        MyClass myClass = MyClass.class.getConstructor(String.class,int.class,int.class,Address.class)
                .newInstance("abc",20,20,address);

        System.out.println(objectToJson(myClass, 0));
    }
}
