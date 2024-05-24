package lld.mediatorDesignPattern;

public interface Colleague {
    public String  getName();
    public void placeBid(int val);
    public void receiveBidNotification(Colleague colleague, int val);
}
