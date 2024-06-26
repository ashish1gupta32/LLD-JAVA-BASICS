package reflection.server;

import com.sun.net.httpserver.HttpServer;


import java.io.OutputStream;

public class WebServer {
    public void startServer() throws Exception{
        HttpServer httpServer=HttpServer.create(ServerConfiguration.getInstance().getServerAddress(),0);

        httpServer.createContext("/greeting").setHandler(exchange ->{
            String responseMessage=ServerConfiguration.getInstance().getGreetingMessage();
            exchange.sendResponseHeaders(200,responseMessage.length());

            OutputStream responseBody =exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        System.out.println(String.format("Starting server on address %s:%d",
                ServerConfiguration.getInstance().getServerAddress().getHostName(),
                ServerConfiguration.getInstance().getServerAddress().getPort()));
        httpServer.start();
    }
}
