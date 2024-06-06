package lld.visitorDesignPattern;

public class MaintenanceVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("maintenance called for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("maintenance called for double room");
    }
}
