package reflection.server;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) throws Exception{
        initConfiguration();
        WebServer webServer=new WebServer();
        webServer.startServer();
    }
    public static void initConfiguration() throws Exception {
        Constructor<ServerConfiguration>constructor=
                ServerConfiguration.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        constructor.newInstance(8080,"Good Day");

    }
}
