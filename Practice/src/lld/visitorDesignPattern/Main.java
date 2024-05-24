package lld.visitorDesignPattern;

public class Main {
    public static void main(String[] args) {
        RoomElement singleRoom=new SingleRoom();
        RoomElement doubleRoom=new DoubleRoom();
        RoomVisitor roomPricingVisitor=new RoomPricingVisitor();
        RoomVisitor maintenanceVisitor=new MaintenanceVisitor();

        singleRoom.accept(roomPricingVisitor);
        singleRoom.accept(maintenanceVisitor);
        doubleRoom.accept(roomPricingVisitor);
        doubleRoom.accept(maintenanceVisitor);

        //second way
        roomPricingVisitor.visit((SingleRoom) singleRoom);

//        instanceof
//        if( singleRoom instanceof SingleRoom){
//            System.out.println("single room class");
//        }
//
//        if( singleRoom instanceof RoomElement){
//            System.out.println("single room class");
//        }


    }
}
