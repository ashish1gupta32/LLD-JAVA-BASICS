package lld.visitorDesignPattern;

public class SingleRoom implements RoomElement{
    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}
