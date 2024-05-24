package lld.visitorDesignPattern;

public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("room pricing called for single room, price: "+100);
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("room pricing called for double room, price: "+200);
    }
}
