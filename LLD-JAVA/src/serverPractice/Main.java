package serverPractice;

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

public class Main {
    private static final String filePath="/Users/ashishgupta/Documents/sublimeText/Practice/src/reflection/server/WebServer.java";
    public static void main(String[] args) throws IOException {
        HttpServer server=HttpServer.create(new InetSocketAddress(9090),0);
        server.createContext("/practice").setHandler((httpExchange -> {
            httpExchange.sendResponseHeaders(200,0);
            OutputStream os=httpExchange.getResponseBody();
            try(FileInputStream fileInputStream= new FileInputStream(filePath)){
                os.write(fileInputStream.readAllBytes());
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            os.close();
        }));
        server.start();


    }
}
