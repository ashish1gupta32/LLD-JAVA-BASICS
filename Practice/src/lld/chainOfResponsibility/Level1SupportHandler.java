package lld.chainOfResponsibility;

public class Level1SupportHandler implements SupportHandler {
    SupportHandler handler;
    @Override
    public void handleRequest(String request) {
        if(request.contains("Level1"))
            System.out.println(request+" handled by "+"Level1SupportHandler");
        else if(handler!=null)
            handler.handleRequest(request);
        else System.out.println("No handler found");
    }

    @Override
    public void setHandler(SupportHandler handler) {
        this.handler = handler;
    }
}
