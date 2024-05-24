package lld.chainOfResponsibility;

public class Level3SupportHandler implements SupportHandler{
    SupportHandler handler;
    @Override
    public void handleRequest(String request) {
        if(request.contains("Level3"))
            System.out.println(STR."\{request} handled by Level3SupportHandler");
        else if(handler!=null)
            handler.handleRequest(request);
        else System.out.println("No handler found");
    }

    @Override
    public void setHandler(SupportHandler handler) {
        this.handler = handler;
    }
}
