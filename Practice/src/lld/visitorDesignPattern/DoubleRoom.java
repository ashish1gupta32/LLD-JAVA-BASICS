package lld.visitorDesignPattern;

public class DoubleRoom implements RoomElement{
    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}
