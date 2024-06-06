package lld.visitorDesignPattern;

public interface RoomElement {
    public void accept(RoomVisitor roomVisitor);
}
