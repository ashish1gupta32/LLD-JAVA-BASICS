package lld.visitorDesignPattern;

public interface RoomVisitor {
    public void visit(SingleRoom singleRoom);
    public void visit(DoubleRoom doubleRoom);
}
