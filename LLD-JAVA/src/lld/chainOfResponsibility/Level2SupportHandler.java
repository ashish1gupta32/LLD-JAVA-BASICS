package lld.chainOfResponsibility;

public class Level2SupportHandler implements SupportHandler{
    SupportHandler handler;
    @Override
    public void handleRequest(String request) {
        if(request.contains("Level2"))
            System.out.println(request+" handled by "+"Level2SupportHandler");
        else if(handler!=null)
            handler.handleRequest(request);
        else System.out.println("No handler found");
    }
    @Override
    public void setHandler(SupportHandler handler) {
        this.handler = handler;
    }
}
