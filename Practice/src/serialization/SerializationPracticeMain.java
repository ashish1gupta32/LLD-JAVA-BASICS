package serialization;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SerializationPracticeMain implements Serializable {
    static String path="/Users/ashishgupta/Documents/sublimeText/Practice/src/serialization/file/serializarion.txt";
    public static void main(String []args) throws Exception {
        String stIn="Testing Serialization";
        byte[] btArray=serialize(stIn);
        String stOut= deserialize(btArray);
        System.out.println(stOut);

        Resource resource=new Resource();
        resource.cnt=10;
        byte[] bytArray=serializeObject(resource);
        Resource rs=deserializeObject(bytArray);
        System.out.println("initial object: "+resource);
        System.out.println("final object:   "+rs);

        serializeObjectFile(resource);
        Resource rs2=deserializeObjectFile();
        System.out.println("initial object: "+resource);
        System.out.println("final object:   "+rs2);
    }

    private static void serializeObjectFile(Resource resource) throws Exception {
        try(OutputStream writer= new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(writer)){
            oos.writeObject(resource);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    private static Resource deserializeObjectFile() throws Exception{
        try(InputStream reader= new FileInputStream(path);
            ObjectInputStream oos=new ObjectInputStream(reader)){
            return (Resource)oos.readObject();
        }
        catch (Exception ex){
            throw ex;
        }

    }



    private static byte[] serializeObject(Object resource) throws Exception{
        try(ByteArrayOutputStream bs=new ByteArrayOutputStream();
            ObjectOutputStream oos =new ObjectOutputStream(bs)
        ){
            oos.writeObject(resource);
            return bs.toByteArray();
        }
        catch (Exception ex){
            throw ex;
        }
    }

    private static Resource deserializeObject(byte[] bytArray) throws Exception {
        try(ByteArrayInputStream bs=new ByteArrayInputStream(bytArray);
        ObjectInputStream os=new ObjectInputStream(bs)){
            Object obj=os.readObject();
            return (Resource) obj;
        }
        catch (Exception ex){
            throw ex;
        }
    }



    private static String deserialize(byte[] btArray) {
        return new String(btArray);
    }
    private static byte[] serialize(String stIn) {
        return stIn.getBytes(StandardCharsets.UTF_8);
    }

}
