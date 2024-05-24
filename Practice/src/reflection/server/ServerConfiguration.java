package reflection.server;

import java.net.InetSocketAddress;

public class ServerConfiguration {
    private static ServerConfiguration serverConfiguration;
    private final InetSocketAddress serverAddress;

    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    private  final String greetingMessage;

    private ServerConfiguration(int port,String greetingMessage){
        this.serverAddress=new InetSocketAddress("localhost",port);
        this.greetingMessage=greetingMessage;
        if(serverConfiguration==null){
            serverConfiguration=this;
        }
    }
    public  static ServerConfiguration getInstance(){return serverConfiguration;}

}
