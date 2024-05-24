package lld.chainOfResponsibility;

public interface SupportHandler {
    public void handleRequest(String request);
    public void setHandler(SupportHandler handler);
}
